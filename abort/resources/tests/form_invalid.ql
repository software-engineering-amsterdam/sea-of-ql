form Box1HouseOwning { 
	hasSoldHouse: "Did you sell a house in 2010?" boolean
	hasBoughtHouse: "Did you buy a house in 2010?" boolean
	if (applepie) {
		sellingPrice: "Price was sold for" money
		privateDebt: "Private debts for the sold house" money
		valueResidue: "Value residue" money(sellingPrice - privateDebt)
	}
	else {
		reasonNotSelling: "Why did you not sell the house?" string
 	}
	age: "How old are you?" integer
	
	// Invalid comparison
	if (20 == hasSoldHouse) {
		invisibleQuestion: "You should never be able to see this. How did you manage?" string
	}
	
	// Invalid comparison
	if (hasSoldHouse == 20) {
		invisibleQuestion2: "Another question you should not see. How did you manage this time?" string
	}
	
	if ("applepie" == "applepie") { "hello" }
	
	if (true && "applepie" || 1 + true || "haha" + 2.000 || +true || -false || 1.2323 + (- bla) || 3==!8) { "hihi" }

	hasSoldHouse: "Just to redeclare and annoy the type checker" integer	
	valueResidue: "Redeclaration of a computed type!" money(29 * 2)
	invalidCalculation: "Invalid calculation for a computed type!" money(apple * 3)
}