form bigBox1HouseOwning {
				   		hasSoldHouse1: "Did you sell a house in 2010?" int
				   		hasSoldHouse2: "Did you by a house in 2010?" money
				   		hasSoldHouse3: "Did you enter a loan for maintenance/reconstruction?" boolean
				   			if (hasSoldHouse1 > hasSoldHouse2){ 
				   				hasSoldHouse4: "Price the house was sold for:" int(hasSoldHouse1 - hasSoldHouse2)
				     			hasSoldHouse5: " Private debts for the sold house:" int(3)
				     			hasSoldHouse6: "Value residue:" int(hasSoldHouse4 - 3) }
						 				else {
											hasSoldHouse7: "Value residue:" boolean(true) 
											hasSoldHouse8: "Value residue:" int(5) 
											hasSoldHouse9: "Value residue:" int(6-3) 
											hasSoldHouse10: "Value residue:" int(4-3)} 
											
											
				   		hasSoldHouse11: "Did you sell a house in 2010?" int 
				   		hasSoldHouse12: "Did you by a house in 2010?" boolean(hasSoldHouse2 == hasSoldHouse11) 
				   		hasSoldHouse13: "Did you enter a loan for maintenance/reconstruction?" boolean
				   			if (hasSoldHouse12){ 
				   				hasSoldHouse14: "Price the house was sold for:" int 
			     			hasSoldHouse15:  "Private debts for the sold house:" int  
				     			hasSoldHouse16: "Value residue:" int(3+1)
				    			hasSoldHouse17:  "Private debts for the sold house:" int}} 
			