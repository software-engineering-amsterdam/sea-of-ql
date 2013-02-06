form Box1HouseOwning {
	hasSoldHouse: "Did you sell a house in 2010?" boolean
	hasBoughtHouse: "Did you buy a house in 2010?" money
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" boolean
    test6Question2: "This is an additional test question"int
    
	
	
	testQuestion1: "This is a test question" string
	if (hasSoldHouse) {
		testQuestion2: "This is an additional test question" int
	    testQuestion23: "This is an additional test question" money (1.00+hasBoughtHouse)
		
		if (hasMaintLoan) {
			testQuestion3: "This is an additional test question" int (88)
		}
		    test6Quesdtion2: "This is an additional test question"int
		
	}
	
	        test6Questisson2: "This is an additional test question" boolean (hasSoldHouse)
	
}