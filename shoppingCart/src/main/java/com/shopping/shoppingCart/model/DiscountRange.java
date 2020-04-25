package com.shopping.shoppingCart.model;

/*************************************************************
 * 
 * @author devanshu.chaurasia
 * Model Class to depict a discount range and applicable 
 * discount rate
 *
 *************************************************************/

public class DiscountRange implements Comparable{
	
	private int upperRange;
    private int lowerRange;
    private int discountRate;
    
    DiscountRange(int lo, int up, int discRate){
    	this.upperRange = up;
    	this.lowerRange=lo;
    	this.discountRate=discRate;
    }
    
    public int getLowerRange() {
    	return this.lowerRange;
    }
    
    public int getUpperRange() {
    	return this.upperRange;
    }
    
    public int getdiscountRate() {
    	return this.discountRate;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + discountRate;
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
		DiscountRange other = (DiscountRange) obj;
		if (discountRate != other.discountRate)
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		return this.discountRate-((DiscountRange)o).discountRate;
	}
	
	public String toString() {
		return this.lowerRange+" : "+this.upperRange+" : "+this.discountRate;
	}
    
}
