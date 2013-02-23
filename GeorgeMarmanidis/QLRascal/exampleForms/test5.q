form foodinwork {
	name: "Name:" string
	surname: "Surname" string
	age: "Age:" integer
	male: "Male:" boolean
	fullname: "Full Name:" string (name+" "+surname)
	/*dawdwadawdwA*/
	
	if (male) {
	 ageindays: "Age in days" integer (365*age)
	}
	
	if(name!="George"){
		work: "Do you work?" boolean
		
		if(age>25 && work){
			typeOfWork: "Where do you work:" string
			enjoyWork: "Do you enjoy your work" boolean
			dateofBirth: "Date of Birth" date
			salary: "How many hours you work per day?" integer
			eatAtWork: "Do you eat at work" boolean
			daysofWork: "How many days you work in a monthly base?" integer
			
			if(eatAtWork && work){
				spendeatAtWork: "How many time you eat in work" integer
				totalhours: "You spent at monthly base for eating in work (minutes):" integer (spendeatAtWork*daysofWork)
			}
			else
			{
				spendeatAtHome: "How many time you are without eating" integer
			}
			
		}
	}
	
}