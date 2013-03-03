
form DemoForm { 

	hasSoldHouse: "In which city do you own a house" text 
	
	hasSoldHouse: "Did you sell a house?" boolean 
	
	hasSoldHouse: "What year have you sold the house?" int
	
	hasSoldHouse: "What was the selling price?" money 
	
	if(hasSoldHouse){
		housePrice: "What was the price of the house?" int
	}
}
