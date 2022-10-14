package com.bv.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="CITIZEN_APPS")
public class CitizenApps {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer appId;
	
	private String fullName;
	
	private String email;
	
	private Long phoneNumber;
	
	private Long ssn;
	
	private String gender;
	
	private String stateName;
	
	private LocalDate dob;
	
	@CreationTimestamp
	private LocalDate createdDate;
	
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	private String createdBy;
	
	private String updatedBy;
	



}
