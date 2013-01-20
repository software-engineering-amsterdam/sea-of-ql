form form1 {
	question1: "is true or false?" boolean
	question2: "text question" boolean
	// Some if statement
	if(question1) {
		question3: "continuing true or false?" 5
	}
	if(question5) {
		question4: "result summary, OR" question1 || question2
	}

	if(question4) {
		question5: "last question" boolean
	}
}