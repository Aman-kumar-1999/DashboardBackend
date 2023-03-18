package com.wipro.dashboard.service;

import java.util.List;

import com.wipro.dashboard.entity.HealthDashboardAppOem;

public interface HealthDashboardAppOemService {

	public List<HealthDashboardAppOem> getHealthDashboardAppOemData() throws Exception;
	public HealthDashboardAppOem addHealthDashboardAppOemData(HealthDashboardAppOem healthDashboardAppOem);
	public void deleteHealthDashboardAppOemData(Long id);	

}
