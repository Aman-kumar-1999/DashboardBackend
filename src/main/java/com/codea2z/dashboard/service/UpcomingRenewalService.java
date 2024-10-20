package com.codea2z.dashboard.service;

import java.util.List;

import com.codea2z.dashboard.entity.UpcomingRenewal;

public interface UpcomingRenewalService {

	List<UpcomingRenewal> getUpcomingRenewalData() throws Exception;

	UpcomingRenewal addUpcomingRenewal(UpcomingRenewal upcomingRenewal);

}
