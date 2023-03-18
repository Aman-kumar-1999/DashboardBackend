package com.wipro.dashboard.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.dashboard.entity.UpcomingRenewal;

@Repository
public interface UpcomingRenewalRepository extends JpaRepository<UpcomingRenewal, Long> {

	public Optional<UpcomingRenewal> findById(Long id);

}
