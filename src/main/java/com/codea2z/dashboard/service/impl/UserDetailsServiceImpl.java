package com.codea2z.dashboard.service.impl;

import com.codea2z.dashboard.entity.User;
import com.codea2z.dashboard.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl/* implements UserDetailsService */ {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = this.userRepository.findByUsername(username);
//        if (user == null) {
//            System.out.println("User not found");
//            throw new UsernameNotFoundException("No user found !!");
//        }
//
//        return user;
//    }
}
