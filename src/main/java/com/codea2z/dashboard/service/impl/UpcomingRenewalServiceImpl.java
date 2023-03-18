package com.wipro.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dashboard.entity.UpcomingRenewal;

import com.wipro.dashboard.repo.UpcomingRenewalRepository;
import com.wipro.dashboard.service.UpcomingRenewalService;

@Service
public class UpcomingRenewalServiceImpl implements UpcomingRenewalService{
	
	
//	public static List<UpcomingRenewalServiceImpl> listOfAplicationId = new ArrayList<>();
	
	@Autowired
	private UpcomingRenewalRepository upcomingRenewalRepository;

	@Override
	public List<UpcomingRenewal> getUpcomingRenewalData() throws Exception{
		// TODO Auto-generated method stub
		
		List<UpcomingRenewal> list = new ArrayList<>();
		
		upcomingRenewalRepository.findAll().forEach(list::add);
		
		return list;
	}

	@Override
	public UpcomingRenewal addUpcomingRenewal(UpcomingRenewal upcomingRenewal) {
		// TODO Auto-generated method stub
		return upcomingRenewalRepository.save(upcomingRenewal);
	}
	
	


}
