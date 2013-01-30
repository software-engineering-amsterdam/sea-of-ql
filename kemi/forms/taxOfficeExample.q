form taxOfficeExample {
  "Did you sell a house in 2010?"
    boolean hasSoldHouse
  
  "Did you buy a house in 2010?"
    boolean hasBoughtHouse
    
  "Did you enter a loan for maintenance/reconstruction?"
    boolean hasMaintLoan
    
  if(hasSoldHouse) {
    "What was the selling price of the house?" 
      money sellingPrice
    
    "Private debts for the sold house:" 
      money privateDebt
    
    "Value residue:" money valueResidue = 
      sellingPrice - privateDebt
  }    
}
