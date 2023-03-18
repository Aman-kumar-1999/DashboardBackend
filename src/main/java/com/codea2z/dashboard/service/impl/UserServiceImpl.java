package com.wipro.dashboard.service.impl;

import com.wipro.dashboard.helper.UserFoundException;
import com.wipro.dashboard.helper.UserNotFoundException;
import com.wipro.dashboard.entity.Role;
import com.wipro.dashboard.entity.User;
//import com.wipro.dashboard.entity.UserRole;
import com.wipro.dashboard.repo.RoleRepository;
import com.wipro.dashboard.repo.UserRepository;
import com.wipro.dashboard.service.UserService;
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
