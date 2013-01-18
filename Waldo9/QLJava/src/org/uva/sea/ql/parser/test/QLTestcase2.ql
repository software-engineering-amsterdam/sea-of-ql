form Box1HouseOwning {
	hasSoldHouse: "Did you sell a house in 2010?" bool
	hasBoughtHouse: "Did you by a house in 2010?" bool
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" bool
	if (hasSoldHouse) {
		sellingPrice: "Price the house was sold for:" int
		privateDebt: "Private debts for the sold house:" int
		valueResidue: "Value residue:" int(sellingPrice - privateDebt)
	}
	else {
		valueResidue: "Value residue:" int(privateDebt - sellingPrice)
	}
	testQuestion1: "This is a test question" string
	if (true) {
		testQuestion2: "This is an additional test question" int
		if (true != false) {
			testQuestion3: "This is an additional test question" string
		}
	}
}