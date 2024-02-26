package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.FeedBack;
import com.app.service.IAdminFeedbackService;

@RestController 
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminFeedBackController {

	@Autowired
	private IAdminFeedbackService adminFeedbackService;
	
	@PostMapping("/feedback-add")
	public ResponseEntity<?> saveFeedback(@RequestBody FeedBack details) {
		return new ResponseEntity<>(adminFeedbackService.saveFeedbackDetails(details), HttpStatus.CREATED);
	}
	
	@GetMapping("/customers")
	public List<FeedBack> getFeedback(){
		return adminFeedbackService.fetchAllCustomers();
	}
//	public ResponseEntity<?> getAllFeedbacks(){
//		
//		List<FeedBack> clist =  adminFeedbackService.fetchAllCustomers();
//		return ResponseEntity.ok(clist);
//	} 
}
