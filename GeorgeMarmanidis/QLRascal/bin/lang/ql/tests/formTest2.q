form Box1HouseOwning2 {
   hasSoldHouse: \"Did you sell a house in 2010?\" boolean 
   hasBoughtHouse: \"Did you by a house in 2010?\" boolean
   if(hasSoldHouse){
   		price: \"in what price\" money
   		year: \" Which Year \" date
   		}
   	else {
   		soldPlaaning: \"Are you thinking of selling this?\" boolean
   	}
   }
   