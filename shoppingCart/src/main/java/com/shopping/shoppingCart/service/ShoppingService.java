package com.shopping.shoppingCart.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.shoppingCart.dao.ShoppingDaoImpl;
import com.shopping.shoppingCart.factory.SlabFactory;
import com.shopping.shoppingCart.model.Customer;
import com.shopping.shoppingCart.model.DiscountRange;
import com.shopping.shoppingCart.model.Slab;

/*************************************************************
 * 
 * @author devanshu.chaurasia
 * Service Class to handle business logic for calculating 
 * Discounted price based on customer, amount and slab 
 * allocated to the customer.
 *
 *************************************************************/
@Service
public class ShoppingService {
	
	@Autowired
	ShoppingDaoImpl shoppingDao;
	
	public Customer findCustomer(long customerId) {
		List<Customer> custList = shoppingDao.getCustomers();
		Customer customer=null;
		for(int index=0;index<custList.size();index++) {
			if(custList.get(index).getCustomerId()==customerId) {
				customer = custList.get(index);
				break;
			}
		}
		return customer;
	}
	
	public long calculatePriceForCustomer(long billingAmount, long customerid) {
		Customer cust= findCustomer(customerid);
		if(null!=cust) {
			Set<DiscountRange> discountRangeList = getDiscountSlab(cust.getSlab());
			return getFinalPrice(discountRangeList, billingAmount);
		}else {
			return 0;
		}
	}
	
	public Set<DiscountRange> getDiscountSlab(String slabType) {
		SlabFactory factory = new SlabFactory();
		Slab slab= factory.getSlab(slabType);
		return slab.getRangeListInSlab();
	}
	
	public long calculatePriceForSlab(long billingAmount, String slabType) {
		Set<DiscountRange> discountRangeList = getDiscountSlab(slabType);
		return getFinalPrice(discountRangeList, billingAmount);
	}
	
	private long getFinalPrice(Set<DiscountRange> discountRangeList, long billingAmount) {
		long finalBillAmount=0;
		long previousCalculatedUpperValue=0;
		
		for(DiscountRange discountRange : discountRangeList) {
			if(billingAmount>discountRange.getUpperRange()) {
				if(discountRange.getUpperRange()!=discountRange.getLowerRange()) { 
					long temp = calculateBill(discountRange.getdiscountRate(), discountRange.getUpperRange()-discountRange.getLowerRange());
					finalBillAmount= finalBillAmount+temp;
				}else {
					long temp=calculateBill(discountRange.getdiscountRate(),billingAmount-discountRange.getLowerRange());
					finalBillAmount= finalBillAmount+temp;
				    break;
				}
				previousCalculatedUpperValue = discountRange.getUpperRange();
			}else {
				long temp=calculateBill(discountRange.getdiscountRate(), billingAmount-previousCalculatedUpperValue);
				finalBillAmount= finalBillAmount+temp;
				break;
			}
		}
		return finalBillAmount;
	}
	

	private long calculateBill(long discountPercentage, long amount) {
		return (amount-(amount*discountPercentage)/100);
	}

}
