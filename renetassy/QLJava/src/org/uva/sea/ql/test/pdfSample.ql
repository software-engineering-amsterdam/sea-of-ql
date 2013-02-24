form Box1HouseOwning { 

	hasSoldHouse : "Did you sell a house in 2010?" bool  
	hasBoughtHouse : "Did you buy a house in 2010?" bool 
	hasMaintLoan : "Did you enter a loan for maintenance/reconstruction?" bool 
	
	if (hasBoughtHouse) { 
		sellingPrice : "Price the house was sold for:" int 
		privateDebt : "Private debts for the sold house:" int  
		valueResidue : "Value residue: " int (sellingPrice - privateDebt) 
		mirrorQ : "mirror" int (valueResidue)
		  		
	}
	
	otinane1: "otinane2" bool (hasSoldHouse) 
}
