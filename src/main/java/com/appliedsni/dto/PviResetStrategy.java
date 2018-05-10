package com.appliedsni.dto;

import java.io.Serializable;

public enum PviResetStrategy implements Serializable{
	
	FIRST_MONDAY_OF_MONTH("FIRST_MONDAY_OF_MONTH"),
	FIRST_THIRD_MONDAY_OF_MONTH("FIRST_THIRD_MONDAY_OF_MONTH"),
	FIRST_MONDAY_OF_QUARTER("FIRST_MONDAY_OF_QUARTER"),
	FIRST_MONDAY_OF_HALF_YEAR("FIRST_MONDAY_OF_HALF_YEAR"),
	LAST_FRIDAY_OF_MONTH("LAST_FRIDAY_OF_MONTH"),
	
	//	PVI Strategies
	NONE("NONE"),
	
	//	GANN Calculators
	GA_FI_ONE("GA_FI_ONE"),
	GA_FI_TWO("GA_FI_TWO"),
	GA_FI_THREE("GA_FI_THREE"),
	GA_FI_FOUR("GA_FI_FOUR"),
	GA_FI_FIVE("GA_FI_FIVE"),
	GA_FI_SIX("GA_FI_SIX"),
	GA_SI_ONE("GA_SI_ONE"),
	GA_SI_TWO("GA_SI_TWO"),
	GA_SI_THIRD("GA_SI_THIRD"),
	GA_TI_ONE("GA_TI_ONE"),
	
	//	Pivot
	END_OF_WEEK("END_OF_WEEK"),
	BEGINNING_OF_WEEK("BEGINNING_OF_WEEK");
	
	private String mName;
	
	PviResetStrategy(String pName){
		mName = pName;
	}

	public String getName() {
		return mName;
	}
}
