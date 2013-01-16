form test4 {
	name: "Name:" string
	surname: "Surname:" string
	age: "Age:" integer
	isEmpl: "Do you work?" boolean
	
	if (isEmpl==true){
		salary: "Annual income:" money
	}
	else
	{
		interest: "What are you seeking in if a job" string  
	}
}