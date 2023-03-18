package com.wipro.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dashboard.entity.HealthDashboardCots;

import com.wipro.dashboard.repo.HealthDashboardCotsRepository;
import com.wipro.dashboard.service.HealthDashboardCotsService;

@Service
public class HealthDashboardCotsServiceImpl implements HealthDashboardCotsService {

	
	public static List<HealthDashboardCotsServiceImpl> listOfAplicationId = new ArrayList<>();
	
	@Autowired
	private HealthDashboardCotsRepository healthDashboardCotsRepository;
	
	@Override
	public List<HealthDashboardCots> getHealthDashboardCotsData()throws Exception{
		// TODO Auto-generated method stub
		
		List<HealthDashboardCots> list = new ArrayList<>();
		
		healthDashboardCotsRepository.findAll().forEach(list::add);
		
		return list;
	}

	@Override
	public HealthDashboardCots addHealthDashboardCotsData(HealthDashboardCots healthDashboardCots) {
		// TODO Auto-generated method stub
		return this.healthDashboardCotsRepository.save(healthDashboardCots);
	}

	@Override
	public void deleteHealthDashboardCots(Long id) {
		// TODO Auto-generated method stub
		this.healthDashboardCotsRepository.deleteById(id);
	}	
	
}
