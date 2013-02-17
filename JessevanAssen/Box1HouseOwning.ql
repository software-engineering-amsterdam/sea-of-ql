form Box1HouseOwning {
    "Did you sell a house in 2010?" hasSoldHouse: boolean
    "Did you by a house in 2010?" hasBoughtHouse: boolean
    "Did you enter a loan for maintenance/reconstruction?" hasMaintLoan: boolean
    if (hasSoldHouse) {
        "Private debts for the sold house:" privateDebt: integer
        "Price the house was sold for:" sellingPrice: integer
		valueResidue = sellingPrice - privateDebt
        "Value residue:" valueResidue
    }
}