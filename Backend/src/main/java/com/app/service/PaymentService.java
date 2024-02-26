package com.app.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.PlaceOrder;
import com.app.entities.BaseEntity;
import com.app.entities.Customer;
import com.app.entities.Order;
import com.app.entities.PMode;
import com.app.entities.Payment;
import com.app.entities.PaymentMode;
import com.app.entities.Status;
import com.app.repositories.AdminUserRepository;
import com.app.repositories.PaymentRepository;

@Service
@Transactional
public class PaymentService implements IPaymentService {
	
	@Autowired
	ICartService cartService ;
	
	@Autowired
	IOrderService orderService ;
	
	@Autowired
	PaymentRepository paymentRepo ;
	
	@Autowired
	AdminUserRepository adminUserRepo;
	
	
	@Override
	public Integer getTotalPayment(int customerId) {
		System.out.println("in a get total payment service ");
		return cartService.getTotalPrice(customerId);
	}


	@Override
	public String placeOrder(PlaceOrder placeOrder) {
		orderService.deletePreviousOrdersOfCustomer(placeOrder.getCustomerId());
		
		Order currentOrder = orderService.placeCurrentCartOrder(placeOrder);
		Optional<Customer> customer=adminUserRepo.findById(placeOrder.getCustomerId());
		Payment currentpayment = new Payment(currentOrder,new PaymentMode(PMode.COD), currentOrder.getPrice(), Status.IN_DELIVERY, LocalDate.now()) ;
		paymentRepo.save(currentpayment) ;
		System.out.println("order placed");
		return "Placed order successfully...";
	}
	
	public PMode getPaymentModeByOrderId(int orderId) {
		Payment payment = paymentRepo.findByOrderId(orderId);
		return payment.getMode().getMode();
	}
	
	public void deleteRecordsByOrderId(int orderId) {
		paymentRepo.deleteByOrderId(orderId);	
	}


	public BaseEntity findByOrderId(Integer id) {
		return paymentRepo.findByOrderId(id);
	}
	
	
	
}
	
	
	
	
