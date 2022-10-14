package com.bv.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenAppBinding {
	
	private String fullName;
	
	private String email;
	
	private Long phoneNumber;
	
	private String gender;
	
	private Long ssn;
	
	private LocalDate dob;

}
