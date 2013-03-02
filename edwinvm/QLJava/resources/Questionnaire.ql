form boxHouse1Owning {
    /*
    "Wat is je naam?" userName: string
    "Wat is je leeftijd?" userAge: integer
    //"Je naam is: " name = userName
    if (userAge == 18) {
    	"U mag auto rijden: " allowedToDrive = userAge == 18
    }
    */
    
    "Did you sell a house in 2010?" hasSoldHouse: boolean
	"Did you by a house in 2010?" hasBoughtHouse: boolean
	"Did you enter a loan for maintenance?" hasMaintLoan: boolean
	if (hasSoldHouse) {
		"Private debts for the sold house:" privateDebt: integer
		"Price the house was sold for:" sellingPrice: integer
		"Value residue:" valueResidue = sellingPrice - privateDebt
	}
}