package com.wipro.dashboard.service;

import java.util.List;


import com.wipro.dashboard.entity.HealthDashboardCots;

public interface HealthDashboardCotsService {
	
	public List<HealthDashboardCots> getHealthDashboardCotsData() throws Exception;

	public HealthDashboardCots addHealthDashboardCotsData(HealthDashboardCots healthDashboardCots);

	public void deleteHealthDashboardCots(Long id);

}
