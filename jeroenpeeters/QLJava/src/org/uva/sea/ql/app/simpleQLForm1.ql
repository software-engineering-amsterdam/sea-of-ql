
form DemoForm { 

	city: "In which city do you own a house" text 
	
	hasSoldHouse: "Did you sell a house?" boolean 
	
	year: "What year have you sold the house?" int
	
	if(hasSoldHouse){
		housePrice: "What was the price of the house?" money
	}
}
