package com.shopping.shoppingCart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shopping.shoppingCart.model.Customer;
import com.shopping.shoppingCart.service.ShoppingService;

@SpringBootTest
class ShoppingCartServiceTest {
  
  @Autowired
  ShoppingService service;

  @DisplayName("Test price Calculation based on Customer Type")
  @Test
  public void testPriceForSlab() {
	  long price = service.calculatePriceForSlab(15000, "Regular");
	  System.out.println(price);
	  assertEquals(13500, price);
  }
  
  @DisplayName("Test price Calculation based on Customer id")
  @Test
  public void testPriceForCustomer() {
	  long price = service.calculatePriceForCustomer(15000, 1);
	  System.out.println(price);
	  assertEquals(13500, price);
  }
  
  @DisplayName("Test price Calculation based on Customer id")
  @Test
  public void testGetCustomer() {
	  Customer customer = service.findCustomer(1);
	  System.out.println(customer.getCustomerType());
	  assertEquals("Regular", customer.getCustomerType());
  }
	
}
