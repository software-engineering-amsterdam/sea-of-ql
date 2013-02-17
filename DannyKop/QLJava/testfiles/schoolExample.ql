form Box1HouseOwning { 
	hasSoldHouse: "Did you sell a house in 2010?" boolean 
	hasBoudghtHouse: "Did you buy a house in 2010?" boolean 
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" boolean
	if ( !hasSoldHouse ) {
		sellingPrice: "Price the house was sold for:" int
		privateDebt: "Private debts for the sold house:" int
		valueResideu: "Value resideu:" int( sellingPrice -  privateDebt)
	} 
}			