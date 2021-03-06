package com.shopping.shoppingCart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shoppingCart.model.Customer;
import com.shopping.shoppingCart.service.ShoppingService;


/*************************************************************
 * 
 * @author devanshu.chaurasia
 * Controller Class to expose Rest APIs
 *
 *************************************************************/

@RestController
@RequestMapping("/discount")
public class ShoppingDiscountController {
	
	@Autowired(required=true)
	ShoppingService service;
	
	@GetMapping("/getCustomer/{customerId}")
	public Customer getCustomer(@PathVariable long customerId) {
		return service.findCustomer(customerId);
	}
	
	@GetMapping("/getCustomerPrice/{customerId}/{billingAmount}")
	public long calculatePriceForCustomer(@PathVariable long customerId, @PathVariable long billingAmount) {
		return service.calculatePriceForCustomer(billingAmount, customerId);
	}
	
	@GetMapping("/getSlabPrice/{slabType}/{billingAmount}")
	public long calculatePriceForSlab(@PathVariable String slabType, @PathVariable int billingAmount) {
		return service.calculatePriceForSlab(billingAmount, slabType);
	}

}
