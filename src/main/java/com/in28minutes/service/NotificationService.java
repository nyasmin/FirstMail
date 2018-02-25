package com.in28minutes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.in28minutes.dto.User;

@Service
public class NotificationService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender){
		this.javaMailSender = javaMailSender;
	}

	public void sendNotification(User user){
		SimpleMailMessage mail= new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("nilofaryasmin.nyt@gmail.com");
		mail.setSubject("Mail Testing");
		mail.setText("Congratulations");
		javaMailSender.send(mail);
	}
}
