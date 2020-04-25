package com.shopping.shoppingCart.model;

/*************************************************************
 * 
 * @author devanshu.chaurasia
 * Premium Customer model class to define premium customers
 *
 *************************************************************/

public class PremiumCustomer implements Customer{
	
	private String customerType="Premium";
    private long customerId;
    String slab;
    
    public PremiumCustomer(){
		slab = "Premium";
	}
	
	private String customername;

	public String getCustomerType() {
		return customerType;
	}
	
	public String getSlab() {
		return this.slab;
	}
	
	public void setSlab(String slab) {
		 this.slab = slab;
	}
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + customerId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PremiumCustomer other = (PremiumCustomer) obj;
		if (customerId != other.customerId)
			return false;
		return true;
	}
}
