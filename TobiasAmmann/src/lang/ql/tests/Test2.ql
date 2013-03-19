form form1 { 
	hasSoldHouse: "Did you sell a house in 2010?" bool
	sellingPrice: "What was the selling price of the house 1?" int
	if (hasSoldHouse) { 
		sellingPrice2: "What was the selling price of the house2?" int
	}
	bla: "Wat komt hier voor een vraag te staat?" int (sellingPrice + 50)
	hasBoughtHouse: "Did you buy a house in 2010?" bool
	if (hasBoughtHouse){
		payprice: "What price did you pay?" int
		taxes: "Have you paid taxes for this?" bool
	}
	if(payprice > 1000){
		taxes2: "Have you paid taxes for this second?" bool
	}
	else{
		fine: "did you ever get a fine?" bool
	}
}