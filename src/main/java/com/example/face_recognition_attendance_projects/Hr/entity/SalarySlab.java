package com.example.face_recognition_attendance_projects.Hr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SalarySlab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;       // e.g., "Junior Developer"
    private String ctc;        // e.g., "6 LPA"
    private String perks;      // e.g., "Laptop, Internet Reimbursement"
    private String benefits;   // e.g., "Health Insurance, PF"
    
    
	public SalarySlab() {}
	public SalarySlab(Long id, String name, String ctc, String perks, String benefits) {
		this.id = id;
		this.name = name;
		this.ctc = ctc;
		this.perks = perks;
		this.benefits = benefits;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCtc() {
		return ctc;
	}
	public void setCtc(String ctc) {
		this.ctc = ctc;
	}
	public String getPerks() {
		return perks;
	}
	public void setPerks(String perks) {
		this.perks = perks;
	}
	public String getBenefits() {
		return benefits;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	@Override
	public String toString() {
		return "SalarySlab [id=" + id + ", name=" + name + ", ctc=" + ctc + ", perks=" + perks + ", benefits="
				+ benefits + "]";
	}


    
}

