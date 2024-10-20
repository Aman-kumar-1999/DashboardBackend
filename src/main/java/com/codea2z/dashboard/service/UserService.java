package com.codea2z.dashboard.service;

import com.codea2z.dashboard.entity.User;
//import com.codea2z.dashboard.entity.UserRole;

import java.util.Set;

public interface UserService {

//    creating user
    public User createUser(User user) throws Exception;

    //get user by username
    public User getUser(String username);

    //delete user by id
    public void deleteUser(Long userId);
}
