form Box1HouseOwning {
	hasSoldHouse: "Did you sell a house in 2010?" bool
	hasBoughtHouse: "Did you by a house in 2010?" bool
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" bool
	if (hasSoldHouse) {
		sellingPrice: "Price the house was sold for:" int
		privateDebt: "Private debts for the sold house:" int
		valueResidue: "Value residue:" int(sellingPrice - privateDebt)
	}
}