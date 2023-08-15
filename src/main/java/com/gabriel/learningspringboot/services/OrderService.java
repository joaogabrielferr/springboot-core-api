package com.gabriel.learningspringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.learningspringboot.entities.Order;
import com.gabriel.learningspringboot.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll()
	{
		return repository.findAll();
	}
	
	public Order findOrder(Long id)
	{
		return repository.findById(id).get();
	}
	

	
	
}
