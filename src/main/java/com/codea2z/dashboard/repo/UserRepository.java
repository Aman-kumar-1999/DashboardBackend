package com.wipro.dashboard.repo;

import com.wipro.dashboard.entity.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
    
    public User findById(long id);
}