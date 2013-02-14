form test  {
				   name: "Name:" string
	   surname: "Surname:" string
	   surname2: "Surname1:" string (surname+"dwadaw")
	   age: "Age:" integer
	   age2: "Age2:" integer
	
	   isEmpl: "Do you work?" boolean
	   completeage: "Complete name:" integer (age+age2)
	
	   if (isEmpl)
		   {
			   	   if(isEmpl==true){
			   	   	   salary: "Annual income:" money 
			   	   }
			   	   else{
			   	   	   salary: "what salary you except?:" money 
		   		   }
			   salary: "what salary you except?:" money 
	   	}
		   else if(!isEmpl)
		   	{
			   	   isEmpl: "Do you work?" boolean
			   	   interests: "What are you seeking in a job?" string  ("dawdawdawd")
		   }
		   else
		   {
			   	   interest: "How you get in here?" string
			   	   interest: "How you get in here?" string 
		   }
}