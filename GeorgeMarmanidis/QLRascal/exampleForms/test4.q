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
			   	   	   attitude: "30Do you see any difference in attitude" boolean 
			   	   	   isEmpl: "30Do you work?" boolean
			   	   }
			   	   else{
			   	   	   work: "what salary you except?:" money 
		   		   }
			   
	   	}
		  else if(agedifference>15)
		   	{
			   	    if(age>20){
			   	   	   attitude: "151adaw" boolean 
			   	   	   isEmpl: "Do you work?15" boolean
			   	   }
			   	   else{
			   	   	   work: "what salary you except?15:" money 
		   		   }
		   }
		   else
		   {
			   	   
			   	   interest: "0How you get in here?" string 
		   }
}