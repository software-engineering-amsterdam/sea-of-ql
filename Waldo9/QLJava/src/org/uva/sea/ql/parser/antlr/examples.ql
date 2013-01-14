form Box1HouseOwning {
	hasSoldHouse: “Did you sell a house in 2010?” boolean
	hasBoughtHouse: “Did you by a house in 2010?” boolean
	hasMaintLoan: “Did you enter a loan for maintenance/reconstruction?” boolean
	if (hasSoldHouse) {
		sellingPrice: “Price the house was sold for:” int
		privateDebt: “Private debts for the sold house:” int
		valueResidue: “Value residue:” int(sellingPrice - privateDebt)
	}
}

form Box1HouseOwning {
	"Did you sell a house in 2010?" hasSoldHouse: boolean
	"Did you by a house in 2010?" hasBoughtHouse: boolean
	"Did you enter a loan for maintenance/reconstruction?" hasMaintLoan: boolean
	if (hasSoldHouse) {
		"Private debts for the sold house:" privateDebt: int
		"Price the house was sold for:" sellingPrice: int
		"Value residue:" valueResidue = sellingPrice - privateDebt
	}
}