package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PlaceOrder;
import com.app.service.IPaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {
	
		@Autowired
		IPaymentService paymentService ;
		
		
		@PostMapping("/place")
		public String placeOrder(@RequestBody PlaceOrder placeOrder ) {	
			return paymentService.placeOrder(placeOrder) ;
		}
		
		@GetMapping("/total/{customerId}")
		public Integer getTotalPrice(@PathVariable int customerId) {
			return paymentService.getTotalPayment(customerId) ;
		}
}
