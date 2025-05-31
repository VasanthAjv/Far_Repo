package com.example.face_recognition_attendance_projects.Hr.export;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.face_recognition_attendance_projects.Hr.entity.Candidate;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelExporter {

	public static void export(List<Candidate> candidates, HttpServletResponse response) throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Candidates");

		Row header = sheet.createRow(0);
		String[] columns = { "ID", "Name", "Email", "Phone", "Role", "Experience", "Current CTC", "Expected CTC",
				"Notice Period", "Source", "Comment", "Status", "Interview Status", "Resume", "Created At" };

		for (int i = 0; i < columns.length; i++) {
			header.createCell(i).setCellValue(columns[i]);
		}

		int rowIdx = 1;
		for (Candidate c : candidates) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(c.getId());
			row.createCell(1).setCellValue(c.getName());
			row.createCell(2).setCellValue(c.getEmail());
			row.createCell(3).setCellValue(c.getPhone());
			row.createCell(4).setCellValue(c.getRoleHiringFor());
			row.createCell(5).setCellValue(c.getYearsOfExperience());
			row.createCell(6).setCellValue(c.getCurrentCTC());
			row.createCell(7).setCellValue(c.getExpectedCTC());
			row.createCell(8).setCellValue(c.getNoticePeriod());
			row.createCell(9).setCellValue(c.getSource());
			row.createCell(10).setCellValue(c.getComment());
			row.createCell(11).setCellValue(c.getScreeningStatus().toString());
			row.createCell(12).setCellValue(c.getInterviewStatus().toString());
			row.createCell(13).setCellValue(c.getResumeLink());
			row.createCell(14).setCellValue(c.getCreatedAt() != null ? c.getCreatedAt().toString() : "");
		}

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=candidates.xlsx");

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		outputStream.flush(); // flush data to client
		workbook.close();
	}

}
