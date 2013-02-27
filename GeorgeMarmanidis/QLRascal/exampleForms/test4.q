form test  {
	name: "Name:" string
	surname: "Surname:" string
	surname2: "Surname1:" string (name + surname)
	age: "Age:" integer
	mothersage: "mothersage:" integer
	/*dawdwdawd*/
	agedifference: "agedifference:" integer (mothersage - age)
	
	if (agedifference>30)
		   {
			   	   if(age>20){
			   	   	   attitude: "30aDo you see any difference in attitude" boolean 
			   	   	   isEmpl: "30aDo you work?" boolean
			   	   }
			   	   else{
			   	   	   work: "30bwhat salary you except?:" money 
		   		   }
			   
	   	}
		  else if(agedifference>15)
		   	{
			   	    if(age>20){
			   	   	   attitude: "15a1adaw" boolean 
			   	   	   isEmpl: "15aDo you work?" boolean
			   	   }
			   	   else{
			   	   	   work: "15bwhat salary you except?15:" money 
		   		   }
		   }
		   else if(agedifference>5){
		   		 attitude: "5a1adaw" boolean 
			   	 isEmpl: "5aDo you work?" boolean
		   }
		   else
		   {
			   	   
			   	   interest: "0How you get in here?" string 
		   }
}