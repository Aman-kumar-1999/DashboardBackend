package com.codea2z.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codea2z.dashboard.entity.HealthDashboardInfra;

import com.codea2z.dashboard.repo.HealthDashboardInfraRepository;
import com.codea2z.dashboard.service.HealthDashboardInfraService;

@Service
public class HealthDashboardInfraServiceImpl  implements HealthDashboardInfraService{
	
	@Autowired
	private HealthDashboardInfraRepository healthDashboardInfraRepository;
	
	@Override
	public List<HealthDashboardInfra> getHealthDashboardInfraData() throws Exception{
		// TODO Auto-generated method stub
		
		List<HealthDashboardInfra> list = new ArrayList<>();
		
		healthDashboardInfraRepository.findAll().forEach(list::add);
		
		return list;
	}

	@Override
	public Object addHealthDashboardInfra(HealthDashboardInfra healthDashboardInfra) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	
	

}
