form asst1 {
   bool hasSoldHouse =  "Did you sell a house in 2010?" 
   bool hasBoughtHouse = "Did you by a house in 2010?"
   bool hasMaintLoan = "Did you enter a loan for maintenance/reconstruction?"
   int dummy = "heyyo" 
    
   if (hasSoldHouse) {
     int sellingPrice = "Price the house was sold for:" 
     float privateDebt = "Private debts for the sold house:" 
     float valueResidue = "Value residue:" (sellingPrice - privateDebt)  
   }  
     
   date DateQ = "Enter your birthday:" 
   bool over = "You are at least 18 yo" (DateQ <=  28.1.1994)
    
}      