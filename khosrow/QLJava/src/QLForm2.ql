form form1 {
	Q1:"This is the first question" boolean
	Q2:"This is the second question" integer
	Q1 = true
	if(Q1){
		"This is a label" (1 + 2)
		Q2 = 3 * 2
		Q3:"This is the third question" integer
		Q3 = Q2 + 3.1
		Q4 (Q3 == Q2 + 3.1):"This is the fourth question" integer
	}
}