/*The QL IDE test */

form Box1{ 
hasSoldHouse: "Did you sell a house in 2010?" money
hasBoughtHouse: "Did you by a house in 2010?" money
hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" money
if (hasSoldHouse > hasBoughtHouse) 
{
sellingPrice: "Price the house was sold for:" integer
privateDebt: "Private debts for he sold house:" integer
valueResidue: "Value residue:" integer(sellingPrice - privateDebt)
}
else 
{
valueResidue: "Value residue:" integer(sellingPrice)
}
}
