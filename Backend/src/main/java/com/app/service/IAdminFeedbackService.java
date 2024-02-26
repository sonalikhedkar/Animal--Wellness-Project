package com.app.service;

import java.util.List;

import com.app.entities.FeedBack;

public interface IAdminFeedbackService {

	FeedBack saveFeedbackDetails(FeedBack details);

	List<FeedBack> fetchAllCustomers();

}
