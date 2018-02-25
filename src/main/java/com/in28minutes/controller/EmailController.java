package com.in28minutes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.dto.EmailMessage;

@RestController
public class EmailController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@RequestMapping(value ="/sendSimpleMail", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String sendEmail(@RequestBody EmailMessage emailMsg){
		sendSimpleEmailMsg(emailMsg);
		return "Email sent successfully";
	}
	
	private void sendSimpleEmailMsg(EmailMessage emailMsg){
		SimpleMailMessage mail= new SimpleMailMessage();
		mail.setTo(emailMsg.getEmailAddress());
		mail.setFrom("nilofaryasmin.nyt@gmail.com");
		mail.setSubject("Mail Testing");
		mail.setText("Congratulations");
		javaMailSender.send(mail);
		
		
		
	}

}
