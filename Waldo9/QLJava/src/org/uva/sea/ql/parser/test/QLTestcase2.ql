form Box1HouseOwning {
	hasSoldHouse: "Did you sell a house in 2010?" bool
	hasBoughtHouse: "Did you by a house in 2010?" bool
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" bool
	if (true) {
		sellingPrice: "Price the house was sold for:" int
		privateDebt: "Private debts for the sold house:" int
		valueResidue: "Value residue:" int(sellingPrice - privateDebt)
	}
	else {
		valueResidue: "Value residue:" int(privateDebt - sellingPrice)
	}
	testQuestion1: "This is a test question" string
	if (5) {
		testQuestion2: "This is an additional test question" int
		if ("aah" != "b") {
			testQuestion3: "This is an additional test question" string
		}
	}
}