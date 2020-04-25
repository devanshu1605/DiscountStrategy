package com.shopping.shoppingCart.model;

/*************************************************************
 * @author devanshu.chaurasia
 * Customer interface to create new Customer with different
 * customer types. Must be implemented when creating a new
 * Customer type.
 *************************************************************/
public interface Customer {
	public String getCustomerType();
	public String getSlab();
	public long getCustomerId();
	public String getCustomerName();
}
