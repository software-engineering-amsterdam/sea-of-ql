/* WORKING */
form MOREIF { 
	OwnHouse: "Do you own a house?" money 
	boughtHouse: "Bought a house?" money
	if(OwnHouse < boughtHouse) { 
		wnHouse: "Do you have remarks to your house?" boolean
	}
	if(wnHouse) { 
		LikeHouse: "Do you like the house?" string 
	} 
}