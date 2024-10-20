package com.codea2z.dashboard.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codea2z.dashboard.config.CryptoUtils;
import com.codea2z.dashboard.entity.JwtRequest;
import com.codea2z.dashboard.entity.User;
import com.codea2z.dashboard.helper.UserNotFoundException;
import com.codea2z.dashboard.repo.UserRepository;


@RestController("/login")
@CrossOrigin("*")
public class LoginActionController {
	
	@Autowired
	private UserRepository userRepository;
	
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
					//map.put("ROLE_ID", userMaster.getAppsInfraRoleMaster().getId());
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
	

}
