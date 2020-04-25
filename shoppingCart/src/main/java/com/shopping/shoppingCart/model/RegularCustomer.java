package com.shopping.shoppingCart.model;

public class RegularCustomer implements Customer{
	
	private long customerId;
	private String customerType="Regular";
	private String customername;
	private String slab;
	
	public RegularCustomer(){
		slab = customerType;
	}

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
		RegularCustomer other = (RegularCustomer) obj;
		if (customerId != other.customerId)
			return false;
		return true;
	}

}
