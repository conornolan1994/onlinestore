package io.conor.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.conor.model.Product;
import io.conor.model.UserOrder;
import io.conor.repository.OrderRepository;
import io.conor.repository.ProductRepository;

@Service
@Transactional
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	
	public List<UserOrder>showAllOrders(){
		
		List<UserOrder> order = new ArrayList<>();
		orderRepository.findAll()
		.forEach(order::add);
		return order;
	}
	
	public UserOrder getOrderById(int orderId)
	{
		return orderRepository.findOne(orderId);
	}
	
	



	public void addOrder(UserOrder order) {
		orderRepository.save(order);
		
	}


	public void updateOrder(int orderId, UserOrder order) {
		orderRepository.save(order);
		
	}


	public void deleteTheOrder(int orderId) {
	
		orderRepository.delete(orderId);
	}
	
	public void saveOrder(UserOrder order) {
		orderRepository.save(order);
	}
	public UserOrder editOrder(int orderId) {
		
		return orderRepository.findOne(orderId);
	}
	

}
