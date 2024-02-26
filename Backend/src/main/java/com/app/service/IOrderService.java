package com.app.service;

import com.app.dto.PlaceOrder;
import com.app.entities.Order;

public interface IOrderService {
	Order placeCurrentCartOrder(PlaceOrder placeOrder) ;

	void deletePreviousOrdersOfCustomer(int customerId);
	
}
