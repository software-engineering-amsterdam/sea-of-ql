form Box1HouseOwning {
	hasSoldHouse: "Did you sell a house in 2010?" money
	hasBoughtHouse: "Did you by a house in 2010?" boolean
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" boolean
	temp1: "Did you enter a loan for maintenance/reconstruction?" int 
	
	if (hasMaintLoan) {
		se67llingPrice: "Price the house was sold for:" int (77- temp1)
		pri8vateDebt: "Private debts for the sold house:" money
		
	    valu: "Value residue:" money(hasSoldHouse+45.50)
	    se13: "Price the house was sold for:" int (100+ temp1)
		se24: "Private debts for the sold house:" money
		if (hasBoughtHouse) {
		sel3lingPrice: "7Price the house was sold for:" int (77- temp1)
		privateDebt: "7Private debts for the sold house:" money
		
	    val3u: "7Value residue:" money(hasSoldHouse+45.50)
	    s3e13: "7Price the house was sold for:" int (100+ temp1)
		s1e24: "7Private debts for the sold house:" money
		
	    se374: "7Value residue:" money(hasSoldHouse+33.00)
		
	}
	else{
		s6e1: "8BPrice the house was sold for:" int (100+ temp1)
		s6e2: "8BPrivate debts for the sold house:" money
		
	    s6e3: "8BValue residue:"  money(hasSoldHouse+33.00)
	
	
	}
	    se34: "Value residue:" money(hasSoldHouse+33.00)
		
	}
	else{
		se1: "BPrice the house was sold for:" int (100+ temp1)
		se2: "BPrivate debts for the sold house:" money
		
	    se3: "BValue residue:"  money(hasSoldHouse+33.00)
	
	
	}
}