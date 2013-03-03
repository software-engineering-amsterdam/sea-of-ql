form box1HouseOwning { 
	hasSoldHouse: "Did you sell a house in 2010?" bool
	hasBoughtHouse: "Did you buy a house in 2010?" bool
	if (hasSoldHouse) { 
		sellingPrice: "What was the selling price of the house?" int
	} elseIf(!hasBoughtHouse){
	whatblabla: "what is blabla?" str	
	} else {
	laatzitten: "laat dan maar zitten!" bool
	}
	if (sellingPrice > 400000){
		taxes: "Have you paid taxes for this?" bool
	}
	hasBoughtHouse2: "Did you buy a house in 2009?" bool
}