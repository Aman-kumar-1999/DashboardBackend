package com.codea2z.dashboard.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codea2z.dashboard.entity.HealthDashboardAppOem;

@Repository
public interface HealthDashboardAppOemRepository extends JpaRepository<HealthDashboardAppOem, Long> {

	public Optional<HealthDashboardAppOem> findById(Long id);
	
	

}
