package com.shopping.shoppingCart.factory;

import com.shopping.shoppingCart.model.PremiumSlab;
import com.shopping.shoppingCart.model.RegularSlab;
import com.shopping.shoppingCart.model.Slab;

public class SlabFactory {

	public Slab getSlab(String slabType){
	      if(slabType == null){
	         return null;
	      }	else if(slabType.equals("Regular")){
	    	  return new RegularSlab();
	      }else if(slabType.equals("Premium")){
	    	  return new PremiumSlab();
	      }
		return null;
	}
	
}
