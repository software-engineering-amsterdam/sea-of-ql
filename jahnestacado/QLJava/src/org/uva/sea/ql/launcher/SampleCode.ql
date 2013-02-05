form Box1HouseOwning {
	hasSoldHouse: "Did you sell a house in 2010?" boolean
	hasBoughtHouse: "Did you buy a house in 2010?" money
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" boolean
	
	testQuestion1: "This is a test question" string
	if (hasSoldHouse) {
		testQuestion2: "This is an additional test question"int
	    testQuestion23: "This is an additional test question" money (100.00+45.9)
		
		if (hasMaintLoan) {
			testQuestion3: "This is an additional test question" int (testQuestion2)
		}
	}
}