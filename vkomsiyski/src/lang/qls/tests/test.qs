stylesheet test;

bool {
color: "red"
}

int {
minimum: 4
widget:spinbox
widget: spinbox // TODO: duplicate rules
}

sellingPrice {
stepSize: -19.3
}



group "hi" {
	hasMaintLoan
	over
}

group "hdi" {
	hasMaintLoan
	over
	hasMaintLoan // TODO: duplicate variables
}

over {
	widget: combobox
}
