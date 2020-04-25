package com.shopping.shoppingCart.model;

import java.util.Set;
/*************************************************************
 * 
 * @author devanshu.chaurasia
 * Slab interface to create new slabs for customer types.
 *
 *************************************************************/
public interface Slab {
	public String getSlabType();
	public Set<DiscountRange> getRangeListInSlab();
}
