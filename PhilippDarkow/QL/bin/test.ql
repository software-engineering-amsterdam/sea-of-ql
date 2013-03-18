/* Working */
form Box1 {
	hasSoldHouse: "Did you sell a house in 2010?" boolean
	hasBoughtHouse: "Did you y a house in 2010?" boolean
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" boolean
if (hasSoldHouse) {
	sellingPrice: "Price the house was sold for:" money
	privateDebt: "Private debts for the sold house:" money
	valueResidue: "Value resdue:" money(sellingPrice - privateDebt)
	}
}