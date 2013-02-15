form box1HouseOwning { 
	hasSoldHouse: "Did you sell a house in 2010?" bool a+b
	hasBoughtHouse: "Did you by a house in 2010?" bool
	if (hasSoldHouse) { 
		sellingPrice: "What was the selling price of the house?" int
	} elseIf(blabla){
	whatblabla: "what is blabla?" str	
	} else {
	laatzitten: "laat dan maar zitten!" bool
	}
	hasBoughtHouse: "Did you by a house in 2010?" bool
}