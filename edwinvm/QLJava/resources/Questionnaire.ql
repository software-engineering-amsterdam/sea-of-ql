form boxHouse1Owning {
    "Did you sell a house in 2010?" hasSoldHouse: boolean
	"Did you by a house in 2010?" hasBoughtHouse: boolean
	"Did you enter a loan for maintenance?" hasMaintLoan: boolean
	if (hasSoldHouse) {
		"Private debts for the sold house:" privateDebt: integer
		"Price the house was sold for:" sellingPrice: integer
		"Value residue:" valueResidue = sellingPrice - privateDebt
	}
	if (hasBoughtHouse) {
	    "You qualify for a house insurance:" qualifiesForInsurance = hasBoughtHouse && hasMaintLoan
	    "What is your first name?" firstName: string
	    "What is your last name?" lastName: string
	    "Entered full name" filledInName = firstName != "" && lastName != ""
	}
}