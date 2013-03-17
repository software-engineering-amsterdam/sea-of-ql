/* WORKING */
form IFELSEMONEY {
	hasSoldHouse: "Did you sell a house in 2010?" money
	hasBoughtHouse: "Did you y a house in 2010?" money
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" boolean
if(hasSoldHouse > hasBoughtHouse) {
	sellingPrice: "Price the house was sold for:" money
	privateDebt: "Private debts for the sold house:" money
	valueResidue: "Value resdue:" money(sellingPrice - privateDebt)
	}else{
		like: "Did you like the survey" boolean
	}
}