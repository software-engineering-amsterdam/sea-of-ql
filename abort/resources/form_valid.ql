/*
	House owning form 

	Copyrighted 2013
*/
form Box1HouseOwning {
	hasSoldHouse: "Did you sell a house in 2010?" boolean
	hasBoughtHouse: "Did you buy a house in 2010?" boolean
	width: "What was the width of the house in meters?" integer
	length: "What was the length of the house in meters?" integer
	if (hasSoldHouse) {
		sellingPrice: "Price was sold for:" money
		privateDebt: "Private debts for the sold house:" money
		valueResidue: "Value residue:" money(sellingPrice - privateDebt)
		pricePerSquareMeter: "Price per square meter" money(sellingPrice / (width * length)) 
	}
	else {
		reasonNotSelling: "Why did you not sell the house?" string
 	}
	area: "Area of the house" integer(width * length) 
	age: "How old are you?" integer
	
	// Impossible #1
	if (+1 == -1 || 1 <= -1 || -1 >= 1 || 1 != 1 || !(1 == 1)) {
		impossible: "For this question it is practically impossible to appear on your screen" integer
	}
	
	// Impossible #2
	if ((0 - 2 > 1) && (3 + 1 < 2)) {
		invisibleQuestion: "You should never be able to see this. How did you manage?" string
		invisibleComputation: "Very weird computation" money(1.337 * 3)
	}
	
	if (false) {
		invisibleQuestion2: "You should never be able to see this. How did you manage?" string
	}
	else {
		visibleQuestion: "You should always see this. Or are you blind?" boolean
	}
}
