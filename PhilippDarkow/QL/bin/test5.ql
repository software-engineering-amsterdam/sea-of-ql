/* Working */
form AND { 
	OwnHouse: "Do you own a house?" boolean
	boughtHouse: "Bought a house?" boolean
	if(OwnHouse && boughtHouse) { 
		Remarks: "Do you have remarks to your house?" string
	} 
} 