
form DemoForm {
	
	hasSoldHouse: "Did you sell a house in the last tax year?" boolean 
	
	if(hasSoldHouse){
		citySoldHouse: "In which city was the house located?" text 
		housePrice: "What was the price of the house?" money
		
	}
	
	currentlyOwnsHouse: "Do you currently own a house?" boolean
	
	if(currentlyOwnsHouse){
		yearBoughtCurrentHouse: "In which year did you buy your current house?" int
		priceCurrentHouse: "For how much did you buy hour current house?" money
		
		if(priceCurrentHouse > 0 && housePrice > priceCurrentHouse){
	
			"You made a profit of {0} in the year {1}": housePrice - priceCurrentHouse, yearBoughtCurrentHouse
		
			hasLoan: "Do you have a mortgage on your current house?" boolean
		}
		
		if(priceCurrentHouse + 100 > 50000){
			"TestLabel {0}": priceCurrentHouse
		}
	}else{
		hasLoan: "Do you have a loan?" boolean
	}
	
	if(hasLoan){
		loanAmount: "How much is the loan?" money
		"You entered the following loan: {0}" : loanAmount
	}
	
}
