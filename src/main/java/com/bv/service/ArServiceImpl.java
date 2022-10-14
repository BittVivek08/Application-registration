package com.bv.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bv.binding.CitizenAppBinding;
import com.bv.entity.CitizenApps;
import com.bv.repository.CitizenAppsRepository;

@Service
public class ArServiceImpl implements ArService{
	
	@Autowired
	private CitizenAppsRepository appRepo;

	@Override
	public Integer createApplication(CitizenAppBinding app) {
		
		String endpointUrl = "https://ssa-web-api.herokuapp.com/ssn/{ssn}";
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> resEntity = rt.getForEntity(endpointUrl, String.class, app.getSsn());
		
		String stateName = resEntity.getBody();
		
		if("New Jersey".equals(stateName)) {
			CitizenApps entity = new CitizenApps();
			BeanUtils.copyProperties(app, entity);
			entity.setStateName(stateName);
			CitizenApps save = appRepo.save(entity);
			
			return save.getAppId();
		}
		return 0;
	}

}
