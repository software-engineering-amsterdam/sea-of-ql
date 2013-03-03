form Box1HouseOwning {
	hasSoldHouse: "Did you sell a house in 2010?" [Bool]
	hasBoughtHouse: "Did you buy a house in 2010" [Bool]
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" [Bool]
	if (hasSoldHouse) then {
		sellingPrice: "Price the house was sold for:" [Int]
		privateDebt: "Private debts for the sold house:" [Int]
		valueResidue: "Value residue:" (sellingPrice - privateDebt) [Int] 
	} endif
}