package com.codea2z.dashboard.service.impl;

import com.codea2z.dashboard.helper.UserFoundException;
import com.codea2z.dashboard.helper.UserNotFoundException;
import com.codea2z.dashboard.entity.Role;
import com.codea2z.dashboard.entity.User;
//import com.codea2z.dashboard.entity.UserRole;
import com.codea2z.dashboard.repo.RoleRepository;
import com.codea2z.dashboard.repo.UserRepository;
import com.codea2z.dashboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user) throws Exception {


        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there !!");
            throw new UserFoundException();
        } else {
            //user create
//            for (UserRole ur : userRoles) {
//                roleRepository.save(ur.getRole());
//            }
            
        		
//            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);

        }

        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
    
    


}
