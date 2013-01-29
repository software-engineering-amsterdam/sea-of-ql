form foodinwork {
	name: "Name:" string
	surname: "Surname" string
	age: "Age:" integer
	male: "Male:" boolean
	
	if (male) {
	 y: "Bla" integer (y+3)
	}
	
	
	
	if(age>12){
		work: "Do you work?" boolean
		study: "Do you study?" boolean (!work)
		
		if(age>25){
			typeOfWork: "Where do you work:" string
			enjoyWork: "Do you enjoy your work" boolean
			dateofBirth: "Date of Birth" date
			salary: "How many hours you work per day?" integer
			eatAtWork: "Do you eat at work" boolean
			daysofWork: "How many days you work in a monthly base?" integer
			
			if(eatAtWork){
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