package com.wipro.dashboard.service;

import java.util.List;

import com.wipro.dashboard.entity.UpcomingRenewal;

public interface UpcomingRenewalService {

	List<UpcomingRenewal> getUpcomingRenewalData() throws Exception;

	UpcomingRenewal addUpcomingRenewal(UpcomingRenewal upcomingRenewal);

}
