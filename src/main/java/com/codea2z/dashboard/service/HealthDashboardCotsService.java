package com.codea2z.dashboard.service;

import java.util.List;


import com.codea2z.dashboard.entity.HealthDashboardCots;

public interface HealthDashboardCotsService {
	
	public List<HealthDashboardCots> getHealthDashboardCotsData() throws Exception;

	public HealthDashboardCots addHealthDashboardCotsData(HealthDashboardCots healthDashboardCots);

	public void deleteHealthDashboardCots(Long id);

}
