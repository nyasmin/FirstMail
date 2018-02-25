package com.in28minutes.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.dto.User;
import com.in28minutes.service.NotificationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private NotificationService notificationService;
	
	private Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@RequestMapping("/signup")
	public String signup(){
		return "Please sign up for our service";
		
	}
	
	@RequestMapping("/signup-success")
	public String signupSuccess(){
		
		User user = new User();
		user.setFirstName("Nilofar");
		user.setLastName("Yasmin");
		user.setEmailAddress("nilofaryasmin.ny@gmail.com");
		try{
		notificationService.sendNotification(user);
		}catch(MailException e){
			logger.info("Get Message" + e.getMessage());
		}
		return "Thank you for registering with us";
		
	}

}
