package com.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.MyOrder;
import com.app.service.OrderService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/my-order/{customerId}")
	public MyOrder getMyOrder(@PathVariable int customerId) {
		MyOrder myorder= orderService.getShippmentDetails(customerId);
		return myorder;
	}
	
}
