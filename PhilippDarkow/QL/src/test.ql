form Box1 {
/* This is a comment */
hasSoldHouse: "Did you sell a house in 2010?" integer
hasBoughtHouse: "Did you by a house in 2010?" integer
hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" string
if (hasBoughtHouse < hasSoldHouse) {
sellingPrice: "Price the house was sold for:" integer
privateDebt: "Private debts for the sold house:" integer
valueResidue: "Value resdue:" integer(sellingPrice - privateDebt)
	}
}