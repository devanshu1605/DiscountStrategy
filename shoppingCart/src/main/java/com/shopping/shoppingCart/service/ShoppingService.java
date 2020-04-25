package com.shopping.shoppingCart.service;

import com.shopping.shoppingCart.dao.ShoppingDaoImpl;
import com.shopping.shoppingCart.factory.SlabFactory;
import com.shopping.shoppingCart.model.Customer;
import com.shopping.shoppingCart.model.DiscountRange;
import com.shopping.shoppingCart.model.Slab;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingService {
	
	@Autowired
	ShoppingDaoImpl shoppingDao;
	
	public Customer findCustomer(long customerId) {
		List<Customer> custList = shoppingDao.getCustomers();
		Customer cust=null;
		for(int i=0;i<custList.size();i++) {
			if(custList.get(i).getCustomerId()==customerId) {
				cust = custList.get(i);
				break;
			}
		}
		return cust;
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

	private long calculateBill(long discountPercentage, long amount) {
		return (amount*((100-discountPercentage)/100));
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
				    finalBillAmount= finalBillAmount+calculateBill(discountRange.getUpperRange()-discountRange.getLowerRange(), discountRange.getdiscountRate());
				}else {
					finalBillAmount= finalBillAmount+calculateBill(billingAmount-discountRange.getLowerRange(), discountRange.getdiscountRate());
				    break;
				}
				previousCalculatedUpperValue = discountRange.getUpperRange();
			}else {
				finalBillAmount= finalBillAmount+calculateBill(billingAmount-previousCalculatedUpperValue, discountRange.getdiscountRate());
				break;
			}
		}
		return finalBillAmount;
	}

}
