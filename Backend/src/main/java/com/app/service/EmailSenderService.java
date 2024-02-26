package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendSimpleEmail(String toEmail,String body,String subject) {
		
		 SimpleMailMessage message = new SimpleMailMessage(); 
	       
	        message.setTo(toEmail); 
	        message.setSubject(subject); 
	        message.setText(body);
	        mailSender.send(message);
	        
	        System.out.println("mail sent");
	}

}
