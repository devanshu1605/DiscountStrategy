package com.shopping.shoppingCart.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RegularSlab implements Slab{

	@Override
	public String getSlabType() {
		return "Regular";
	}

	@Override
	public Set<DiscountRange> getRangeListInSlab() {
		
		Set<DiscountRange> discRangeSet= new TreeSet<>();
		
		DiscountRange discRange1 = new DiscountRange(0,5000,0);
		DiscountRange discRange2 = new DiscountRange(5000,10000,10);
		DiscountRange discRange3 = new DiscountRange(10000,10000,20);
		discRangeSet.add(discRange1);
		discRangeSet.add(discRange3);
		discRangeSet.add(discRange2);

		return discRangeSet;
	}

}
