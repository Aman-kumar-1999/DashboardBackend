package com.wipro.dashboard.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.dashboard.entity.HealthDashboardInfra;

@Repository
public interface HealthDashboardInfraRepository extends JpaRepository<HealthDashboardInfra, Long> {

	public Optional<HealthDashboardInfra> findById(Long id);

}
