package com.shopping.shoppingCart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.shopping.shoppingCart.factory.CustomerFactory;
import com.shopping.shoppingCart.model.Customer;
import com.shopping.shoppingCart.model.PremiumCustomer;
import com.shopping.shoppingCart.model.PremiumSlab;
import com.shopping.shoppingCart.model.RegularCustomer;
import com.shopping.shoppingCart.model.RegularSlab;
import com.shopping.shoppingCart.model.Slab;


/*************************************************************
 * 
 * @author devanshu.chaurasia
 * Class to imitate DAO Layer
 *
 *************************************************************/

@Component
public class ShoppingDaoImpl {
	
	HashMap<Slab, List<Customer>>customerMap = new HashMap<>();
	List<Customer> regularCustList;
	List<Customer> premCustList;
	ShoppingDaoImpl(){
		regularCustList= new ArrayList<>();
		premCustList= new ArrayList<>();
		
		CustomerFactory factory = new CustomerFactory();
		RegularCustomer cust2= (RegularCustomer) factory.getCustomer("Regular");
		cust2.setCustomerId(2);
		RegularCustomer cust1= (RegularCustomer) factory.getCustomer("Regular");
		cust1.setCustomerId(1);
		regularCustList.add(cust1);
		regularCustList.add(cust2);
		customerMap.put(new RegularSlab(), regularCustList);
		
		PremiumCustomer cust3= (PremiumCustomer) factory.getCustomer("Premium");
		cust3.setCustomerId(3);
		PremiumCustomer cust4= (PremiumCustomer) factory.getCustomer("Premium");
		cust4.setCustomerId(4);
		premCustList.add(cust3);
		premCustList.add(cust4);
		customerMap.put(new PremiumSlab(), regularCustList);
	}
	
	public Map<Slab, List<Customer>> getCustomerMap() {
		return customerMap;
	}
	
	public List<Customer> getCustomers() {
		List<Customer> custList= new ArrayList<>();
		custList.addAll(regularCustList);
		custList.addAll(premCustList);
		return custList;
	}
	
}
