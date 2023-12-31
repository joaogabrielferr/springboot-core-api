package com.gabriel.apispringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.apispringboot.entities.Order;
import com.gabriel.apispringboot.entities.DTOs.InsertOrderDTO;
import com.gabriel.apispringboot.services.OrderService;


import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
			
		List<Order> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findOrder(@PathVariable Long id){
		
		Order Order = service.findOrder(id);
		
		return ResponseEntity.ok().body(Order);
		
	}
	
	@PostMapping
	public ResponseEntity<Order> insertOrder(@Valid @RequestBody InsertOrderDTO insertOrderDTO)
	{
		
		Order order = service.insertOrder(insertOrderDTO);
		
		return ResponseEntity.ok().body(order);
		
	}
	
}
