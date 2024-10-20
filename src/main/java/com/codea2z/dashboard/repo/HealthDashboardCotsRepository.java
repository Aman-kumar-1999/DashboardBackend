package com.codea2z.dashboard.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codea2z.dashboard.entity.HealthDashboardCots;

@Repository
public interface HealthDashboardCotsRepository extends JpaRepository<HealthDashboardCots, Long> {

	public Optional<HealthDashboardCots> findById(Long id);

}
