package com.shopping.shoppingCart.model;

import java.util.Set;
import java.util.TreeSet;

/*************************************************************
 * 
 * @author devanshu.chaurasia
 * Model Class to represent Premium Slab type Discount rate
 *
 *************************************************************/

public class PremiumSlab implements Slab{
	

	@Override
	public String getSlabType() {
		return "Premium";
	}

	@Override
	public Set<DiscountRange> getRangeListInSlab() {
		
		Set<DiscountRange> discRangeSet= new TreeSet<>();
		
		DiscountRange discRange1 = new DiscountRange(0,4000,10);
		DiscountRange discRange2 = new DiscountRange(4000,8000,15);
		DiscountRange discRange3 = new DiscountRange(8000,12000,20);
		DiscountRange discRange4 = new DiscountRange(12000,12000,30);
		discRangeSet.add(discRange1);
		discRangeSet.add(discRange3);
		discRangeSet.add(discRange2);
		discRangeSet.add(discRange4);
		
		return discRangeSet;
	}

}
