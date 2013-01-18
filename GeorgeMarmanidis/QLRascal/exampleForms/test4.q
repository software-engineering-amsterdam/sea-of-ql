form test4 {
	name: "Name:" string
	surname: "Surname:" string
	age: "Age:" integer
	isEmpl: "Do you work?" boolean
	
	if (age>=18)
	{
		if(isEmpl==true){
		salary: "Annual income:" money
		}
		else{
		salary: "what salary you except?:" money
		}
	}
	else if(age>15 && age<18)
	{
		interests: "What are you seeking in a job?" string  (a-b)
	}
	else
	{
		interest: "How you get in here?" string
		interest: "How you get in here?" string
	}
}