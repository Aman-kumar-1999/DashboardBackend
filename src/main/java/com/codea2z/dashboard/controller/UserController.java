package com.codea2z.dashboard.controller;

import com.codea2z.dashboard.helper.UserFoundException;
import com.codea2z.dashboard.helper.UserNotFoundException;


import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codea2z.dashboard.config.CryptoUtils;
import com.codea2z.dashboard.entity.HealthDashboardAppOem;
import com.codea2z.dashboard.entity.HealthDashboardCots;
import com.codea2z.dashboard.entity.HealthDashboardInfra;
import com.codea2z.dashboard.entity.HealthDashboardPortal;
import com.codea2z.dashboard.entity.JwtRequest;
import com.codea2z.dashboard.entity.UpcomingRenewal;
import com.codea2z.dashboard.entity.Role;
import com.codea2z.dashboard.entity.User;
//import com.codea2z.dashboard.entity.UserRole;
import com.codea2z.dashboard.repo.HealthDashboardAppOemRepository;
import com.codea2z.dashboard.repo.HealthDashboardCotsRepository;
import com.codea2z.dashboard.repo.HealthDashboardInfraRepository;
import com.codea2z.dashboard.repo.HealthDashboardPortalRepository;
import com.codea2z.dashboard.repo.UpcomingRenewalRepository;
import com.codea2z.dashboard.repo.UserRepository;

import com.codea2z.dashboard.service.HealthDashboardAppOemService;
import com.codea2z.dashboard.service.HealthDashboardCotsService;
import com.codea2z.dashboard.service.HealthDashboardInfraService;
import com.codea2z.dashboard.service.HealthDashboardPortalService;
import com.codea2z.dashboard.service.UpcomingRenewalService;
import com.codea2z.dashboard.service.UserService;



//
//import com.codea2z.dashboard.entity.dashboardInfraIseApps;
//import com.codea2z.dashboard.entity.dashboardServerHealthStatus;
//import com.codea2z.dashboard.entity.Role;
//import com.codea2z.dashboard.entity.User;
//import com.codea2z.dashboard.entity.UserRole;
//import com.codea2z.dashboard.repo.UserRepository;
//import com.codea2z.dashboard.service.dashboardInfraAppsService;
//import com.codea2z.dashboard.service.dashboardInfraIseAppsService;
//import com.codea2z.dashboard.service.dashboardServerHealthStatusService;
//import com.codea2z.dashboard.service.UserService;
//import org.apache.coyote.Response;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;

//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

//	@Autowired
//	private dashboardServerHealthStatusRepository dashboardServerHealthStatusRepository;
	
	@Autowired
	private UpcomingRenewalRepository upcomingRenewalRepository;
	
	@Autowired
	private HealthDashboardAppOemRepository healthDashboardAppOemRepository;
	
	@Autowired
	private HealthDashboardCotsRepository healthDashboardCotsRepository;
	
	@Autowired
	private HealthDashboardPortalRepository healthDashboardPortalRepository;
	
	@Autowired
	private HealthDashboardInfraRepository healthDashboardInfraRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HealthDashboardAppOemService healthDashboardAppOemService;
	
	@Autowired
	private HealthDashboardCotsService healthDashboardCotsService;
	
	@Autowired
	private HealthDashboardInfraService healthDashboardInfraService;
	
	@Autowired
	private HealthDashboardPortalService healthDashboardPortalService;
	
	@Autowired
	private UpcomingRenewalService upcomingRenewalService;
	
//	@Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	//   For user_master_dashboard API
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
//	PoST (Create) API for USER_ROLE_dashboard table 
	
	
	
	
	
	
	@RequestMapping(value ="/api/login", method = RequestMethod.POST, produces ="application/json")
	public Map<String, Object> validationForUser(@RequestBody JwtRequest loginAction) throws UserNotFoundException, Exception
	{

		try
		{
			System.out.println("userName.."+loginAction.getUsername());
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			User userMaster = this.userRepository.findByUsername(loginAction.getUsername());
			if(userMaster!= null)
			{
				String UIpassword = loginAction.getPassword();
				String hashpassword = CryptoUtils.byteArrayToHexString(CryptoUtils.computeHash(UIpassword));
				System.out.println("Password.."+hashpassword);
				if(userMaster.getPassword().equals(hashpassword))
				{
					map.put("STATUS", "SUCCESS");
					map.put("USER", userMaster);
//					map.put("ROLE_ID", userMaster.getAppsInfraRoleMaster().getId());
				}
				else
				{
					map.put("STATUS", "FAILURE");
					map.put("MESSAGE", "Invalid credentials. kindly check!");
				}
			}
			else
			{
				throw new UserNotFoundException("No Credentials found with provided data!");
			}
			return map;
		
		}catch (UserNotFoundException e) {
			throw new  UserNotFoundException(e.getMessage());
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
	
	}
	

	@PostMapping("/createUser")
	 public User createUser(@RequestBody User user) throws Exception {

		

        user.setProfile("default.png");
//        encoding password with bcryptpasswordencoder

       String pass= CryptoUtils.byteArrayToHexString(CryptoUtils.computeHash(user.getPassword()));
       user.setPassword(pass);

//        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(2L);
        role.setRoleName("NORMAL");

//        UserRole userRole = new UserRole();
//        userRole.setUser(user);
//        userRole.setRole(role);
//
//        roles.add(userRole);


        return this.userService.createUser(user);

    }
	
	
	

	
// Get User By userName
    
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    //delete the user by id
    
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
    }


    //update api
    
	// build update employee REST API
    
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateEmployee(@PathVariable long id,@RequestBody User user) {
        User updateUser = userRepository.findById(id);
//        		.orElseThrow(() -> new UserNotFoundException("Employee not exist with id: " + id));

        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setEmail(user.getEmail());
        updateUser.setPhone(user.getPhone());
        updateUser.setProfile(user.getProfile());
        updateUser.setRoleid(user.getRoleid());

        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }
    
    
    
//    @PutMapping("{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user) {
//    	User updateUser = userRepository.findById(id);
////                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
//    	
//
//    	updateUser.setUsername(user.getUsername());
//    	updateUser.setPassword(user.getPassword());
//    	updateUser.setFirstName(user.getFirstName());
//    	updateUser.setLastName(user.getLastName());
//    	updateUser.setEmail(user.getEmail());
//    	updateUser.setPhone(user.getPhone());
//    	updateUser.setProfile(user.getProfile());
//  
//        userRepository.save(updateUser);
//
//        return ResponseEntity.ok(updateUser);
//    }
	
    


    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

	

	
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

	// Gating the data of whole table
    
	@GetMapping("/healthdashboardappoem")
	public List<HealthDashboardAppOem> getHealthDashboardAppOem() throws Exception{
		
		List <HealthDashboardAppOem> appliId= healthDashboardAppOemService.getHealthDashboardAppOemData();
		return appliId;
	}
	
	// For Update 
	
	 @PutMapping("/healthdashboardappoem/{id}")
	 public ResponseEntity<HealthDashboardAppOem> updateHealthDashboardAppOem(@PathVariable Long id,@RequestBody HealthDashboardAppOem healthDashboardAppOem) {
		 HealthDashboardAppOem healthDashboard = healthDashboardAppOemRepository.findById(id).get();
//	         .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
	    	

		 healthDashboard.setApplicationName(healthDashboardAppOem.getApplicationName());
		 healthDashboard.setApplicationOem(healthDashboardAppOem.getApplicationOem());
		 healthDashboard.setHealthDasboard(healthDashboardAppOem.getHealthDasboard());
		 healthDashboard.setL1(healthDashboardAppOem.getL1());
		 healthDashboard.setL2(healthDashboardAppOem.getL2());
		 healthDashboard.setOemSupportStatus(healthDashboardAppOem.getOemSupportStatus());
		 healthDashboard.setServerIp(healthDashboardAppOem.getServerIp());
		
		 

		 healthDashboardAppOemRepository.save(healthDashboard);

	        return ResponseEntity.ok(healthDashboard);
	    }
	 
	 // Create HealthDashboardAppOem 
	 
	 @PostMapping("/healthdashboardappoem")
	    public ResponseEntity<HealthDashboardAppOem> addHealthdashboardappoem(@RequestBody HealthDashboardAppOem healthDashboardAppOem) {
		 HealthDashboardAppOem healthDashboardAppOemNew = new HealthDashboardAppOem();
		 healthDashboardAppOemNew = healthDashboardAppOem;
		 this.healthDashboardAppOemService.addHealthDashboardAppOemData(healthDashboardAppOemNew);
	        return ResponseEntity.ok(healthDashboardAppOemNew);
	    }
	
	 @DeleteMapping("/healthdashboardappoem/{id}")
	 public void deleteHealthDashboardAppOem(@PathVariable Long id) {
		 this.healthDashboardAppOemService.deleteHealthDashboardAppOemData(id);
	 }
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	// Gating the whole data of 
	 
	@GetMapping("/healthdashboardcots")
	public List<HealthDashboardCots> getHealthDashboardCots() throws Exception{
		
		List <HealthDashboardCots> appliId= healthDashboardCotsService.getHealthDashboardCotsData();
		return appliId;
	}

	
	// Updating the database table from id
	
	
	 @PutMapping("/healthdashboardcots/{id}")
	 public ResponseEntity<HealthDashboardCots> updateHealthDashboardCots(@PathVariable Long id,@RequestBody HealthDashboardCots healthDashboardCots) {
		 HealthDashboardCots healthDashboard = healthDashboardCotsRepository.findById(id).get();
//	         .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
	    	

		 healthDashboard.setApplicationName(healthDashboardCots.getApplicationName());
		 healthDashboard.setDatetime(healthDashboardCots.getDatetime());
		 healthDashboard.setCleanUpMountPoint(healthDashboardCots.getCleanUpMountPoint());
		 healthDashboard.setFrequency(healthDashboardCots.getFrequency());
		 healthDashboard.setHealthDashboard(healthDashboardCots.getHealthDashboard());
		 healthDashboard.setInfoupdatedBy(healthDashboardCots.getInfoupdatedBy());
		 healthDashboard.setMountPointUtilization(healthDashboardCots.getMountPointUtilization());		 
		 healthDashboard.setServerId(healthDashboardCots.getServerId());
		 healthDashboard.setServiceStatus(healthDashboardCots.getServiceStatus());
		 healthDashboard.setThresholdMountPoint(healthDashboardCots.getThresholdMountPoint());

		 healthDashboardCotsRepository.save(healthDashboard);

	        return ResponseEntity.ok(healthDashboard);
	    }
	
//	 Create healthdashboardcots
	 
	 @PostMapping("/healthdashboardcots")
	    public ResponseEntity<HealthDashboardCots> addHealthdashboardcots(@RequestBody HealthDashboardCots healthDashboardCots) {
	        return ResponseEntity.ok(this.healthDashboardCotsService.addHealthDashboardCotsData(healthDashboardCots));
	    }	
	 
	 @DeleteMapping("/healthdashboardcots/{id}")
	 public void deleteHealthDashboardCots(@PathVariable Long id) {
		 this.healthDashboardCotsService.deleteHealthDashboardCots(id);
	 }
	
	//   For dashboard_infra_ise_apps table API
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	 // Gating data of table
	 
	@GetMapping("/healthdashboardinfra")
	public List<HealthDashboardInfra> getHealthDashboardInfra() throws Exception{
		
		List <HealthDashboardInfra> appliId= healthDashboardInfraService.getHealthDashboardInfraData();
		return appliId;
	}
	
	 @PutMapping("/healthdashboardinfra/{id}")
	 public ResponseEntity<HealthDashboardInfra> updateHealthDashboardInfra(@PathVariable Long id,@RequestBody HealthDashboardInfra healthDashboardInfra) {
		 HealthDashboardInfra healthDashboard = healthDashboardInfraRepository.findById(id).get();
//	         .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
	    	

		 healthDashboard.setApplicationName(healthDashboardInfra.getApplicationName());
		 healthDashboard.setDatatime(healthDashboardInfra.getDatatime());
		 healthDashboard.setUpu(healthDashboardInfra.getUpu());
		 healthDashboard.setFrequency(healthDashboardInfra.getFrequency());
		 healthDashboard.setHealthDashboard(healthDashboardInfra.getHealthDashboard());
		 healthDashboard.setInfoupdatedBy(healthDashboardInfra.getInfoupdatedBy());
		 healthDashboard.setDiskUtilization(healthDashboardInfra.getDiskUtilization());		 
		 healthDashboard.setServerId(healthDashboardInfra.getServerId());
		 healthDashboard.setMemory(healthDashboardInfra.getMemory());

		 healthDashboardInfraRepository.save(healthDashboard);

	        return ResponseEntity.ok(healthDashboard);
	    }
	
	 
	 
	 @PostMapping("/healthdashboardinfra")
	    public ResponseEntity<Object> addHealthDashboardInfra(@RequestBody HealthDashboardInfra healthDashboardInfra) {
	        return ResponseEntity.ok(this.healthDashboardInfraService.addHealthDashboardInfra(healthDashboardInfra));
	    }	
	 @DeleteMapping("/healthdashboardinfra/{id}")
	 public void deleteHealthDashboardInfra(@PathVariable Long id) {
		 this.healthDashboardInfraRepository.deleteById(id);
	 }
	
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	// Get API 
	
	@GetMapping("/healthdashboardportal")
	public List<HealthDashboardPortal> getdashboardInfraIseApps() throws Exception{
		
		List <HealthDashboardPortal> appliId= healthDashboardPortalService.getHealthDashboardPortalData();
		return appliId;
	}
	
	@PutMapping("/healthdashboardportal/{id}")
	 public ResponseEntity<HealthDashboardPortal> updateHealthDashboardPortal(@PathVariable Long id,@RequestBody HealthDashboardPortal healthDashboardPortal) {
		HealthDashboardPortal healthDashboard = healthDashboardPortalRepository.findById(id).get();
//	         .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
	    	
		 healthDashboard.setApplicationName(healthDashboardPortal.getApplicationName());
		 healthDashboard.setDatetime(healthDashboardPortal.getDatetime());
		 healthDashboard.setCleanUpMountPoint(healthDashboardPortal.getCleanUpMountPoint());
		 healthDashboard.setFrequency(healthDashboardPortal.getFrequency());
		 healthDashboard.setHealthDashboard(healthDashboardPortal.getHealthDashboard());
		 healthDashboard.setInfoupdatedBy(healthDashboardPortal.getInfoupdatedBy());
		 healthDashboard.setMountPointUtilization(healthDashboardPortal.getMountPointUtilization());		 
		 healthDashboard.setServerId(healthDashboardPortal.getServerId());
		 healthDashboard.setServiceStatus(healthDashboardPortal.getServiceStatus());
		 healthDashboard.setThresholdMountPoint(healthDashboardPortal.getThresholdMountPoint());

		 healthDashboardPortalRepository.save(healthDashboard);

	        return ResponseEntity.ok(healthDashboard);
	    }
	
	@PostMapping("/healthdashboardportal")
    public ResponseEntity<HealthDashboardPortal> addHealthDashboardPortal(@RequestBody HealthDashboardPortal healthDashboardPortal) {
        return ResponseEntity.ok(this.healthDashboardPortalService.addHealthDashboardPortalData(healthDashboardPortal));
    }
	
	@DeleteMapping("/healthdashboardportal/{id}")
	 public void deleteHealthdashboardportal(@PathVariable Long id) {
		 this.healthDashboardPortalRepository.deleteById(id);
	 }
	
	
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
//	Get
	
	@GetMapping("/upcominguenewal")
	public List<UpcomingRenewal> getUpcomingRenewal() throws Exception{
		
		List <UpcomingRenewal> appliId= upcomingRenewalService.getUpcomingRenewalData();
		return appliId;
	}
	
	
//	update 
	
	@PutMapping("/upcominguenewal/{id}")
	 public ResponseEntity<UpcomingRenewal> updateupcomingRenewalRepository(@PathVariable Long id,@RequestBody UpcomingRenewal upcomingRenewal) {
		 UpcomingRenewal healthDashboard = upcomingRenewalRepository.findById(id).get();
//	         .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
	    	

		 healthDashboard.setApplicationInfra(upcomingRenewal.getApplicationInfra());
		 healthDashboard.setDueData(upcomingRenewal.getDueData());
		 healthDashboard.setInfoUpdateBy(upcomingRenewal.getInfoUpdateBy());
		 healthDashboard.setOwner(upcomingRenewal.getOwner());
		 healthDashboard.setInfoUpdateBy(upcomingRenewal.getInfoUpdateBy());
		 healthDashboard.setApplicationInfra(upcomingRenewal.getApplicationInfra());
		 
		 
		 

		 upcomingRenewalRepository.save(healthDashboard);

	        return ResponseEntity.ok(healthDashboard);
	    }
	
	@PostMapping("/upcominguenewal")
    public ResponseEntity<UpcomingRenewal> addUpcomingRenewal(@RequestBody UpcomingRenewal upcomingRenewal) {
        return ResponseEntity.ok(this.upcomingRenewalService.addUpcomingRenewal(upcomingRenewal));
    }
	
	@DeleteMapping("/upcominguenewal/{id}")
	 public void deleteUpcominguenewal(@PathVariable Long id) {
		 this.upcomingRenewalRepository.deleteById(id);
	 }
	
	
	
	//  For dashboard_SERVER_HEALTH_STATUS API
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
//	Get API for dashboard_SERVER_HEALTH_STATUS table  by using id
	
//	@GetMapping("/healthstatusbyid/{id}")
//	public dashboardServerHealthStatus getHealthStatusById(@PathVariable("id") int id) throws Exception{
//		
//		return dashboardServerHealthStatusService.getdashboardServerHealthStatusByid(id);
//	}
	

    
    
    

}
