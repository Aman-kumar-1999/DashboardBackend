package com.codea2z.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codea2z.dashboard.entity.HealthDashboardAppOem;
import com.codea2z.dashboard.repo.HealthDashboardAppOemRepository;
import com.codea2z.dashboard.service.HealthDashboardAppOemService;

@Service
public class HealthDashboardAppOemServiceImpl implements HealthDashboardAppOemService {
	

	public static List<HealthDashboardAppOemServiceImpl> listOfAplicationId = new ArrayList<>();
	
	@Autowired
	private HealthDashboardAppOemRepository healthDashboardAppOemRepository;
	
	@Override
	public List<HealthDashboardAppOem> getHealthDashboardAppOemData() throws Exception{
		// TODO Auto-generated method stub
		
		List<HealthDashboardAppOem> list = new ArrayList<>();
		
		healthDashboardAppOemRepository.findAll().forEach(list::add);
		
		return list;
		
	}

	@Override
	public HealthDashboardAppOem addHealthDashboardAppOemData(HealthDashboardAppOem healthDashboardAppOem) {
		// TODO Auto-generated method stub
		return this.healthDashboardAppOemRepository.save(healthDashboardAppOem);
		
	}

	@Override
	public void deleteHealthDashboardAppOemData(Long id) {
		// TODO Auto-generated method stub
		try {
			healthDashboardAppOemRepository.findById(id);
			healthDashboardAppOemRepository.deleteById(id);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	
	
}
