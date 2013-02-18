form testForm {
	stringQuestion: "Please insert a string." string
	integerQuestion: "Please insert a number." integer
	booleanQuestion: "Please check of uncheck this option." boolean
	computedQuestion: "This question is computed. Number times 100" integer(integerQuestion*100)
}