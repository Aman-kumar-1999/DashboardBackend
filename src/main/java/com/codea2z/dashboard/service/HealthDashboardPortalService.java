package com.codea2z.dashboard.service;

import java.util.List;

import com.codea2z.dashboard.entity.HealthDashboardPortal;

public interface HealthDashboardPortalService {

	public List<HealthDashboardPortal> getHealthDashboardPortalData() throws Exception;

	public HealthDashboardPortal addHealthDashboardPortalData(HealthDashboardPortal healthDashboardPortal);

}
