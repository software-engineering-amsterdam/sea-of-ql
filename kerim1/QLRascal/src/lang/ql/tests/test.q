/*
 a comment
*/
form Box1HouseOwning {
 	hasSoldHouse: "Did you sell a house in 2010?" bool
 	hasBoughtHouse: "Did you by a house in 2010?" bool
  	hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" bool
   	valueResidue: "Value:" int
   	
   	// comment 
   	if (hasSoldHouse) {
  		sellingPrice: "Price the house was sold for:" int
  		privateDebt: "Private debts for the sold house:" int
     	valueResidue: "Value residue:" int(sellingPrice - privateDebt)
     	
     	if (valueResidue < (1 == sellingPrice)) {
     		privateDebt: "Private debt:" int(hasSoldHouse)
     	}
     	else if (undefined) {
     		valueResidue: "Residue:" bool(sellingPrice - privateDebt)
     	}
   	}
   	// comment
   	else { 
   		sellingPrice: "Price the house was sold for:" int // comment
   	}
   	
   	if (x) {
   		y: "This is y:" bool
   	}
   	if (y) {
   		x: "This is x" bool
   	}
}