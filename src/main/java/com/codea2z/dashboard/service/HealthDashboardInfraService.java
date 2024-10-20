package com.codea2z.dashboard.service;

import java.util.List;

import com.codea2z.dashboard.entity.HealthDashboardInfra;

public interface HealthDashboardInfraService {

	

	public List<HealthDashboardInfra> getHealthDashboardInfraData() throws Exception;

	public Object addHealthDashboardInfra(HealthDashboardInfra healthDashboardInfra);

}
