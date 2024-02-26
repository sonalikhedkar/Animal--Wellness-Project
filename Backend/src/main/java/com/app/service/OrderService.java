
package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.MyOrder;
import com.app.dto.PlaceOrder;
import com.app.entities.Cart;
import com.app.entities.Customer;
import com.app.entities.Order;
import com.app.entities.PMode;
import com.app.entities.Payment;
import com.app.entities.Product;
import com.app.entities.Status;
import com.app.repositories.CartRepository;
import com.app.repositories.OrderRepository;
import com.app.repositories.PaymentModeRepository;
import com.app.repositories.PaymentRepository;
import com.app.repositories.UserRepository;
@Service
@Transactional
public class OrderService implements IOrderService {
	
	@Autowired
	IUserService userService ;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	ICartService cartService ;
	
	@Autowired
	CartRepository cartRepo ;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	AdminUserService adminUserService;
	
	
	
	@Override
	public Order placeCurrentCartOrder(PlaceOrder placeOrder ) {
		Customer currentCustomer = userService.getCustomerById(placeOrder.getCustomerId());
		Cart currentCart = currentCustomer.getCart() ;
		Order order = null ;       
		if(placeOrder.getPayMode().equals("COD") )
			order = new Order(currentCustomer, currentCart, currentCart.getQuantity(), Status.PLACED, cartService.getTotalPrice(currentCustomer.getId()), LocalDate.now()); 
		currentCart.setStatus(Status.PLACED);
		cartRepo.save(currentCart);
		return orderRepo.save(order);
	}
	
	public Order getOrderDetailsByCustmerId(int customerId) {
		Order order = orderRepo.findByCustomerId(customerId);
		return order ;	
	}
	
	
	public MyOrder getShippmentDetails(int customerId) {
		Order order = getOrderDetailsByCustmerId(customerId) ;
		List<Product> products = cartService.getAllItemsByCart(customerId);
		if(products==null) {
			return null;
		}
		else {
		MyOrder myOrder = new MyOrder(products,order.getQuantity(), order.getStatus(), paymentService.getPaymentModeByOrderId(order.getId()),order.getDate(),order.getCustomer().getAddress(),order.getPrice());
		return myOrder;
		}
	}
	
	public void deletePreviousOrdersOfCustomer(int customerId) {
		Order order=orderRepo.findByCustomerId(customerId);
		if(order!=null) {
		Integer paymentId=paymentService.findByOrderId(order.getId()).getId();
		paymentService.deleteRecordsByOrderId(order.getId());
		orderRepo.deleteByCustomerId(customerId);
		}
		else {
			System.out.println("no order found for this customer+");
		}
	}
	
}
