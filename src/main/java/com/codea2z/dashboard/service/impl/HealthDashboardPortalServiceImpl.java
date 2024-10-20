package com.codea2z.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codea2z.dashboard.entity.HealthDashboardPortal;

import com.codea2z.dashboard.repo.HealthDashboardPortalRepository;
import com.codea2z.dashboard.service.HealthDashboardPortalService;

@Service
public class HealthDashboardPortalServiceImpl implements HealthDashboardPortalService {

	public static List<HealthDashboardPortalServiceImpl> listOfAplicationId = new ArrayList<>();
	
	@Autowired
	private HealthDashboardPortalRepository healthDashboardPortalRepository;
	
	@Override
	public List<HealthDashboardPortal> getHealthDashboardPortalData()  throws Exception{
		// TODO Auto-generated method stub
		
		List<HealthDashboardPortal> list = new ArrayList<>();
		
		healthDashboardPortalRepository.findAll().forEach(list::add);
		
		return list;
	}

	@Override
	public HealthDashboardPortal addHealthDashboardPortalData(HealthDashboardPortal healthDashboardPortal) {
		// TODO Auto-generated method stub
		
		return healthDashboardPortalRepository.save(healthDashboardPortal);
	}
	

	

}
