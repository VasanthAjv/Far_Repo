package com.example.face_recognition_attendance_projects.Hr.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.example.face_recognition_attendance_projects.Hr.dto.CandidateFilterDTO;
import com.example.face_recognition_attendance_projects.Hr.entity.Candidate;

import jakarta.persistence.criteria.Predicate;

public class CandidateSpecifications {

	public static Specification<Candidate> withFilters(CandidateFilterDTO filter) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (filter.getName() != null && !filter.getName().isEmpty()) {
				predicates.add(cb.like(cb.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));
			}

			if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
				predicates.add(cb.like(cb.lower(root.get("email")), "%" + filter.getEmail().toLowerCase() + "%"));
			}

			if (filter.getPhone() != null && !filter.getPhone().isEmpty()) {
				predicates.add(cb.like(cb.lower(root.get("phone")), "%" + filter.getPhone().toLowerCase() + "%"));
			}

			if (filter.getRoleHiringFor() != null && !filter.getRoleHiringFor().isEmpty()) {
				predicates.add(cb.equal(cb.lower(root.get("roleHiringFor")), filter.getRoleHiringFor().toLowerCase()));
			}

			if (filter.getSource() != null && !filter.getSource().isEmpty()) {
				predicates.add(cb.equal(cb.lower(root.get("source")), filter.getSource().toLowerCase()));
			}

			if (filter.getMinYearsOfExperience() != null) {
				predicates
						.add(cb.greaterThanOrEqualTo(root.get("yearsOfExperience"), filter.getMinYearsOfExperience()));
			}

			if (filter.getMaxYearsOfExperience() != null) {
				predicates.add(cb.lessThanOrEqualTo(root.get("yearsOfExperience"), filter.getMaxYearsOfExperience()));
			}

			if (filter.getMinCurrentCTC() != null) {
				predicates.add(cb.greaterThanOrEqualTo(root.get("currentCTC"), filter.getMinCurrentCTC()));
			}

			if (filter.getMaxCurrentCTC() != null) {
				predicates.add(cb.lessThanOrEqualTo(root.get("currentCTC"), filter.getMaxCurrentCTC()));
			}

			if (filter.getMinExpectedCTC() != null) {
				predicates.add(cb.greaterThanOrEqualTo(root.get("expectedCTC"), filter.getMinExpectedCTC()));
			}

			if (filter.getMaxExpectedCTC() != null) {
				predicates.add(cb.lessThanOrEqualTo(root.get("expectedCTC"), filter.getMaxExpectedCTC()));
			}

			if (filter.getMinNoticePeriod() != null) {
				predicates.add(cb.greaterThanOrEqualTo(root.get("noticePeriod"), filter.getMinNoticePeriod()));
			}

			if (filter.getMaxNoticePeriod() != null) {
				predicates.add(cb.lessThanOrEqualTo(root.get("noticePeriod"), filter.getMaxNoticePeriod()));
			}

			if (filter.getStartCreatedAt() != null) {
				predicates.add(cb.greaterThanOrEqualTo(root.get("createdAt"), filter.getStartCreatedAt()));
			}

			if (filter.getEndCreatedAt() != null) {
				predicates.add(cb.lessThanOrEqualTo(root.get("createdAt"), filter.getEndCreatedAt()));
			}

			if (filter.getScreeningStatus() != null) {
				predicates.add(cb.equal(root.get("screeningStatus"), filter.getScreeningStatus()));
			}

			if (filter.getInterviewStatus() != null) {
				predicates.add(cb.equal(root.get("interviewStatus"), filter.getInterviewStatus()));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
