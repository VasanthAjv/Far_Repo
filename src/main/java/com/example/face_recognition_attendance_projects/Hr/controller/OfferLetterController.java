package com.example.face_recognition_attendance_projects.Hr.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.face_recognition_attendance_projects.Hr.dto.OfferLetterRequestDTO;
import com.example.face_recognition_attendance_projects.Hr.entity.Candidate;
import com.example.face_recognition_attendance_projects.Hr.entity.OfferLetter;
import com.example.face_recognition_attendance_projects.Hr.entity.SalarySlab;
import com.example.face_recognition_attendance_projects.Hr.repos.CandidateRepository;
import com.example.face_recognition_attendance_projects.Hr.repos.OfferLetterRepository;
import com.example.face_recognition_attendance_projects.Hr.repos.SalarySlabRepository;
import com.example.face_recognition_attendance_projects.Hr.serivce.impl.PdfService;
import com.hr.service.impl.EmailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/offers")
@Tag(name = "Offer Letter", description = "APIs for managing offer letters")
public class OfferLetterController {

	private final CandidateRepository candidateRepo;
	private final SalarySlabRepository slabRepo;
	private final OfferLetterRepository offerRepo;
	private final com.hr.service.impl.EmailService emailService; // Custom service for sending emails
	private final PdfService pdfService; // Custom service to generate PDFs

	public OfferLetterController(CandidateRepository candidateRepo, SalarySlabRepository slabRepo,
			OfferLetterRepository offerRepo, EmailService emailService, PdfService pdfService) {
		this.candidateRepo = candidateRepo;
		this.slabRepo = slabRepo;
		this.offerRepo = offerRepo;
		this.emailService = emailService;
		this.pdfService = pdfService;
	}

	// 1. Get form data: candidate + salary slabs
	@Operation(summary = "Get offer letter form data")
	@GetMapping("/form/{candidateId}")
	public ResponseEntity<?> getOfferForm(@PathVariable Long candidateId) {
		Candidate candidate = candidateRepo.findById(candidateId)
				.orElseThrow(() -> new RuntimeException("Candidate not found"));

		List<SalarySlab> slabs = slabRepo.findAll();

		Map<String, Object> response = new HashMap<>();
		response.put("candidate", candidate);
		response.put("salarySlabs", slabs);
		return ResponseEntity.ok(response);
	}

	// 2. Create & Send Offer Letter
	@Operation(summary = "Create and send an offer letter")
	@PostMapping("/generate")
	public ResponseEntity<?> generateAndSendOffer(@RequestBody OfferLetterRequestDTO request) {
		Candidate candidate = candidateRepo.findById(request.getCandidateId())
				.orElseThrow(() -> new RuntimeException("Candidate not found"));
		SalarySlab slab = slabRepo.findById(request.getSlabId())
				.orElseThrow(() -> new RuntimeException("Slab not found"));

		OfferLetter offer = new OfferLetter();
		offer.setCandidate(candidate);
		offer.setSalarySlab(slab);
		offer.setJoiningDate(request.getJoiningDate());
		offer.setOfferStatus("SENT");
		offer.setSentDate(LocalDateTime.now());

		String pdfPath = pdfService.generateOfferPDF(candidate, slab, request.getJoiningDate());
		offer.setPdfPath(pdfPath);

		offer = offerRepo.save(offer);

		emailService.sendOfferEmail(candidate.getEmail(), pdfPath);

		return ResponseEntity.ok("Offer letter sent and saved successfully.");
	}

	// 3. Resend Offer Letter
	@Operation(summary = "Resend an offer letter to candidate")
	@PostMapping("/resend/{offerId}")
	public ResponseEntity<?> resendOffer(@PathVariable Long offerId) {
		OfferLetter offer = offerRepo.findById(offerId).orElseThrow(() -> new RuntimeException("Offer not found"));

		emailService.sendOfferEmail(offer.getCandidate().getEmail(), offer.getPdfPath());

		offer.setOfferStatus("RESENT");
		offer.setSentDate(LocalDateTime.now());
		offerRepo.save(offer);

		return ResponseEntity.ok("Offer letter resent to candidate.");
	}

	// 4. Decline Offer Letter
	@Operation(summary = "Decline an offer letter")
	@PostMapping("/decline/{offerId}")
	public ResponseEntity<?> declineOffer(@PathVariable Long offerId) {
		OfferLetter offer = offerRepo.findById(offerId).orElseThrow(() -> new RuntimeException("Offer not found"));

		offer.setOfferStatus("DECLINED");
		offerRepo.save(offer);

		return ResponseEntity.ok("Offer letter declined.");
	}

	// 5. Download Offer Letter PDF
	@Operation(summary = "Download offer letter PDF")
	@GetMapping("/download/{offerId}")
	public ResponseEntity<FileSystemResource> downloadPDF(@PathVariable Long offerId) {
		OfferLetter offer = offerRepo.findById(offerId).orElseThrow(() -> new RuntimeException("Offer not found"));

		FileSystemResource file = new FileSystemResource(offer.getPdfPath());

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=offer-letter.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(file);
	}
}
