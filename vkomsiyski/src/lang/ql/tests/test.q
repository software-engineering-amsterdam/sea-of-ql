form Box1HouseOwning {
   boolean hasSoldHouse for "Did you sell a house in 2010?" 
   boolean hasBoughtHouse for "Did you by a house in 2010?" 
   boolean 
   hasMaintLoan for "Did you enter a loan for maintenance/reconstruction?"

	boolean name = 5 for "label"
	boolean name = 5 for "label"


   if (hasSoldHouse) {
     integer sellingPrice for "Price the house was sold for:"
     integer privateDebt for "Private debts for the sold house:" 
     integer valueResidue = (sellingPrice - privateDebt) for "Value residue:"
   }
   
   
   if (hasSoldHouse) {
     integer sellingPrice for "Price the house was sold for:"
	}
}