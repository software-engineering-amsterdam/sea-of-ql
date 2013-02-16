form TestForm {
	enteredInt: "Enter an integer:" int
	enteredString: "Enter a string:" string
	enteredBool: "Enter a bool:" bool
	
	if (enteredString >= "12345") {
		a: "a" bool
		if (enteredString > "12345") {
			bIf: "b if" bool
		}
		else {
			bElse: "b else" bool
		}
		c: "c" bool
	}
}