form test4  {
	name: "Name:" string
	surname: "Surname:" string
	surname: "Surname:" string
	age: "Age:" integer
	age2: "Age2:" integer
	
	isEmpl: "Do you work?" boolean
	completeage: "Complete name:" integer (age +age2)
	
	if (isEmpl)
	{
		if(false){
		salary: "Annual income:" money
		}
		else{
		salary: "what salary you except?:" money
		}
	}
	else if(!isEmpl)
	{
	isEmpl: "Do you work?" boolean (true)
		interests: "What are you seeking in a job?" string  ("dawdawdawd")
	}
	else
	{
		interest: "How you get in here?" string
		interest: "How you get in here?" string
	}
}