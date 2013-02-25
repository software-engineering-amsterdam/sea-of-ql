form form3 {
	hasSoldHouse: "Did you sell a house in 2010?" boolean
	hasBoughtHouse: "Did you by a house in 2010?" boolean	
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" boolean
	if(hasSoldHouse){		
		privateDebt: "Private debts for the sold house:" integer
		sellingPrice: "Price the house was sold for:" money
		"Value residue:" (sellingPrice - privateDebt)
	}
}