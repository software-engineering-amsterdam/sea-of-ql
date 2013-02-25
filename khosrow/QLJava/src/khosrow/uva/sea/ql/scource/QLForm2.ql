form form1 {
	Q1:"This is the first question" boolean
	Q2:"This is the second question" integer	
	if(Q1){		
		Q3:"This is the third question" integer		
		Q4:"This is the fourth question" integer
		"This is a label" (Q3 + Q4)
		if(Q4 > 2) {
			Q5: "this is Q5" string
		}
	}
	Q6(Q1 && (Q3 + Q4) > 1):"This is the Q6 question" integer
}