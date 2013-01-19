form Box1HouseOwning {
	hasSoldHouse: "Did you sell a house in 2010?" boolean
	hasBoughtHouse: "Did you buy a house in 2010?" boolean
	if (hasSoldHouse) {
		sellingPrice: "Price was sold for:" money
		privateDebt: "Private debts for the sold house:" money
		valueResidue: "Value residue:" money(sellingPrice - privateDebt)
	}
	else {
		reasonNotSelling: "Why did you not sell the house?" string
 	}
	age: "How old are you?" integer
}