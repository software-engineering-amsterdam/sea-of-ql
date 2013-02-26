/* not working */
form ORAND { 
	hasMaintLoan: "Did you enter a loan for maintenancere/construction?" boolean
	hasSoldHouse: "Did you sold a house?" boolean 
	if(hasMaintLoan || hasSoldHouse) {
		sellingPrice: "Price the house was sold for:" integer 
	}
	/*if(hasMainLoan && hasSoldHouse){
		testQues: "How much did you pay for the house" money
	} */
}