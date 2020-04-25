package com.shopping.shoppingCart.factory;

import com.shopping.shoppingCart.model.Customer;
import com.shopping.shoppingCart.model.PremiumCustomer;
import com.shopping.shoppingCart.model.RegularCustomer;

public class CustomerFactory {
	
	public Customer getCustomer(String customerType){
	      if(customerType == null){
	         return null;
	      }	else if(customerType.equals("Regular")){
	    	  return new RegularCustomer();
	      }else if(customerType.equals("Premium")){
	    	  return new PremiumCustomer();
	      }
		return null;
	}

}
