
form DemoForm { 
	
	if(hasSoldHouse){
		initialPrice: "Price you bough the house for?" 	money
		sellPrice	: "Price you sold the house for?" 	money
		
		if( (sellPrice - initialPrice) > 250000){
			payedTaxes: "Did you already pay taxes?" boolean
		}
		
	}
}
