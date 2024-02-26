package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.FeedBack;
import com.app.repositories.AdminFeedbackRepository;

@Service
public class AdminFeedbackService implements IAdminFeedbackService{

	@Autowired
	AdminFeedbackRepository feedbackrepo;
	@Override
	public FeedBack saveFeedbackDetails(FeedBack details) {
		return feedbackrepo.save(details);
	}
	@Override
	public List<FeedBack> fetchAllCustomers() {
		return feedbackrepo.getAll();
	}
	
}
