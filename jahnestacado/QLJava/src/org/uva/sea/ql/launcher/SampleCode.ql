form Box1HouseOwning {
	hasSoldHouse: "Did you sell a house in 2010?" boolean
	hasBoughtHouse: "Did you buy a house in 2010?" money
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" boolean
    testQuestion1: "This is an additional test question" string
    
	
	
	testQuestio2n1: "This is a test question" int
	if (hasSoldHouse) {
		testQuestion2: "This is an additional test question" int
	    testQuestion23: "This is an additional test question" money (1.00+hasBoughtHouse)
		
		if (hasMaintLoan) {
			testQuestion3: "This is an additional test question" int (88)
		}
		    test6Quesdtion2: "This is an additional test question" money (hasBoughtHouse)
		
	}
	
	        test6Questisson2: "10.This is an additional test question" boolean (hasSoldHouse)
		hasBoughtHwouse: "Did you buy a house in 2010?" string (testQuestion1)
}