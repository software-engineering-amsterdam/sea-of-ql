form Box1HouseOwning {
	hasSoldHouse: "Did you sell a house in 2010?" boolean
	hasBoughtHouse: "Did you buy a house in 2010?" boolean
	width: "What was the width of the house in meters?" integer
	length: "What was the length of the house in meters?" integer
	if (hasSoldHouse) {
		sellingPrice: "Price was sold for:" money
		privateDebt: "Private debts for the sold house:" money
		valueResidue: "Value residue:" money(sellingPrice - privateDebt)
	}
	else {
		reasonNotSelling: "Why did you not sell the house?" string
 	}
}