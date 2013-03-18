form a {
	hasSoldHouse: "Did you sell a house in 2010?" boolean
	hasBoughtHouse: "Did you by a house in 2010?" boolean(true)
	if (hasSoldHouse) {
		sellingPrice: "Price the house was sold for:" integer
		buyingPrice: "Price the house was bought for:" integer
		sellingPrice2: "Overvalue:" integer(sellingPrice - buyingPrice)
	}
}