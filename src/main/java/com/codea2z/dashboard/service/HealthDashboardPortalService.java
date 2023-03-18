package com.wipro.dashboard.service;

import java.util.List;

import com.wipro.dashboard.entity.HealthDashboardPortal;

public interface HealthDashboardPortalService {

	public List<HealthDashboardPortal> getHealthDashboardPortalData() throws Exception;

	public HealthDashboardPortal addHealthDashboardPortalData(HealthDashboardPortal healthDashboardPortal);

}
