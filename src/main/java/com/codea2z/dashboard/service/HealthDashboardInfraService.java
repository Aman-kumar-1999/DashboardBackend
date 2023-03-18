package com.wipro.dashboard.service;

import java.util.List;

import com.wipro.dashboard.entity.HealthDashboardInfra;

public interface HealthDashboardInfraService {

	

	public List<HealthDashboardInfra> getHealthDashboardInfraData() throws Exception;

	public Object addHealthDashboardInfra(HealthDashboardInfra healthDashboardInfra);

}
