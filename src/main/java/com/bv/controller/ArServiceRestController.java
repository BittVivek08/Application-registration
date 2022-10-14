package com.bv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bv.binding.CitizenAppBinding;
import com.bv.service.ArService;

@RestController
public class ArServiceRestController {
	
	@Autowired
	private ArService service;
	
	@PostMapping("/app")
	public ResponseEntity<String> createCitizenApp(@RequestBody CitizenAppBinding app){
		
		Integer appId = service.createApplication(app);
		
		if(appId > 0) {
			return new ResponseEntity<>("App Created with AppId " +appId, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("This SSN is not belongs to New Jersey State",HttpStatus.BAD_REQUEST);
		}
	}

}
