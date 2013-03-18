form a {
	hasSoldHouse: "Did you sell a house in 2010?" boolean
	housesOwned: "How many houses do you own?" integer
	if (hasSoldHouse) {
		sellingPrice: "Price the house was sold for:" money
		buyingPrice: "Price the house was bought for:" money
		overValue: "Overvalue:" money(sellingPrice - buyingPrice)
	}
}