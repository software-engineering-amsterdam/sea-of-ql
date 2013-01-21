form Box1HouseOwning {
   taxId: "Please enter your tax identification number" string
   hasSoldHouse: "Did you sell a house in 2010?" boolean
   hasBoughtHouse: "Did you by a house in 2010?" boolean
   hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" boolean
   if (hasSoldHouse || (hasBoughtHouse == hasMaintLoan)) {
     sellingPrice: "Price the house was sold for:" money
     privateDebt: "Private debts for the sold house:" money
     valueResidue: "Value residue:" money(sellingPrice - privateDebt)
     if(valueResidue > 20000) {
     	askedForPermissionValRes20 : "Did you ask for permission to have a value residue larger than 20000?" boolean
     }
     /**
     this is a multi line comment
     */
     if(sellingPrice < 80000) {
     	askedForPermissionSelPri80 : "Did you ask for permission to sell a house for less than 80000?" boolean
     	if(askedForPermissionSelPri80) {
     		askedForPermissionSelPri80Who : "Who did you ask for permission to sell a house for less than 80000?" boolean
     	}
     }
   }
}
