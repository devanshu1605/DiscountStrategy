package com.shopping.shoppingCart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shoppingCart.model.Customer;
import com.shopping.shoppingCart.service.ShoppingService;

@RestController
@RequestMapping("/discount")
public class ShoppingDiscountController {
	
	@Autowired
	ShoppingService service;
	
	@GetMapping("/getCustomer/{customerId}")
	public Customer getCustomer(@PathVariable long customerId) {
		return service.findCustomer(customerId);
	}
	
	@GetMapping("/getCustomer/{customerId}/{billingAmount}")
	public long calculatePriceForCustomer(@PathVariable long customerId, @PathVariable long billingAmount) {
		return service.calculatePriceForCustomer(billingAmount, customerId);
	}
	
	@GetMapping("/getCustomer/{slabType}/{billingAmount}")
	public long calculatePriceForSlab(@RequestParam long billingAmount, @RequestParam String slabType) {
		return service.calculatePriceForSlab(billingAmount, slabType);
	}

}
