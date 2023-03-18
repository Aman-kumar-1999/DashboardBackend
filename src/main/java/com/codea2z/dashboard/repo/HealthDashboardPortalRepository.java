package com.wipro.dashboard.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.dashboard.entity.HealthDashboardPortal;

@Repository
public interface HealthDashboardPortalRepository extends JpaRepository<HealthDashboardPortal, Long> {

	Optional<HealthDashboardPortal> findById(Long id);

}
