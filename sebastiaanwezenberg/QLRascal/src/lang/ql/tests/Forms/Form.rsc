module lang::ql::tests::Forms::Form

import lang::ql::tests::TestHelper;

public test bool testForm1() 
	= pf("form Hello { \"Money?\" money myIncome }") is form
	;

public test bool testForm2() 
	= pf("form Hello { \"Dept?\" money myTax = myIncome * 0.40 }") is form
	;

public test bool readForm1() 
	= parseForm(|project://QL-R//src/lang/ql/tests/Forms/Form1.q|) is form
	;