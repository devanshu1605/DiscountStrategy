package com.shopping.shoppingCart.model;

import java.util.Set;

public interface Slab {
	public String getSlabType();
	public Set<DiscountRange> getRangeListInSlab();
}
