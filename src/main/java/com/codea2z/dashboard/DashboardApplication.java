package com.wipro.dashboard;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.dashboard.entity.Role;
import com.wipro.dashboard.entity.User;
//import com.wipro.dashboard.entity.UserRole;
import com.wipro.dashboard.helper.UserFoundException;
import com.wipro.dashboard.service.UserService;

@SpringBootApplication
public class DashboardApplication {

  

    public static void main(String[] args) {


        SpringApplication.run(DashboardApplication.class, args);


        System.out.println("Our Sourse code is in the running State");
        
    }



}
