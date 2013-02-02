form Box1HouseOwning {
	hasSoldHouse: "Did you sell a house in 2010?" boolean
	hasBoughtHouse: "Did you by a house in 2010?" boolean
	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" boolean
	temp1: "Did you enter a loan for maintenance/reconstruction?" int 
	
	if (hasBoughtHouse) {
		sellingPrice: "Price the house was sold for:" int (77- temp1)
		privateDebt: "Private debts for the sold house:" money
		
	    valu: "Value residue:" money(hasSoldHouse+45.50)
	    se13: "Price the house was sold for:" int (100+ temp1)
		se24: "Private debts for the sold house:" money
		
	    se34: "Value residue:" money(hasSoldHouse+33.00)
		
	}
	else{
		se1: "Price the house was sold for:" int (100+ temp1)
		se2: "Private debts for the sold house:" money
		
	    se3: "Value residue:" money(hasSoldHouse+33.00)
	
	
	}
}