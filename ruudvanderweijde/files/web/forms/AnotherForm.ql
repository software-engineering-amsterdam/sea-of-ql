form AnotherForm {
	hasSoldHouse: "Did you sell a house in 2010?" boolean;
	hasBoughtHouse: "Did you by a house in 2010?" boolean
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" boolean
	if (1+1==2) { 
		a: "1+1==2" string
	} else {
		b: "hidden" integer
	}
	if (true&&true&&true&&true&&hasSoldHouse) { 
		sellingPrice1: "Price the house was sold for:" integer
		if (anotherIf) {
			sellingPrice4: "Price the house was sold for:" integer
		}
		privateDebt1: "Private debts for the sold house:" integer
		valueResidue1: "Value residue:" integer(sellingPrice1 - privateDebt1)
	} else {
		sellingPrice2: "Price the house was sold for:" integer
		privateDebt2: "Private debts for the sold house:" integer
		valueResidue2: "Value residue:" integer(sellingPrice2 - privateDebt2)
	}
	if (true&&true&&true&&true&&hasSoldHouse) { 
		reason: "Why did you sell your house?:" string
	}

	finalQuestion: "Please confirm that you have filled in everything correctly?" boolean
	terms: "I accept the terms... etc" boolean 
}
