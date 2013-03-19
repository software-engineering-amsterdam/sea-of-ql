form form3 { 
	hasSoldHouse: "Did you sell a house in 2010?" bool
	x: "X" int
	bla: "Bla" int (x + 100)
	hasBoughtHouse: "Did you buy a house in 2010?" bool
	if (bla > 101){
		taxes: "Have you paid taxes for this?" bool
	}
	
}