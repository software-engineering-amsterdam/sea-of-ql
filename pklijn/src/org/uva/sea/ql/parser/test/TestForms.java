package org.uva.sea.ql.parser.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.form.Form;

public class TestForms {

	private IParse parser;
	
	public TestForms() {
		this.parser = new ANTLRParser();
	}
	
	@Test 
	public void testFormParser() throws ParseError {
		assertEquals(parser.parseForm("form testForm1 {\n" +
				"  demoQuestion: \"Is this really a question?\" boolean\n" +
				"}").getClass(),Form.class);
		assertEquals(parser.parseForm("form testForm2 {\n" +
				"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
				"hasBoughtHouse: \"Have you bought a house in 2012?\" string\n" +
				"}").getBody().size(),2);
		assertEquals(parser.parseForm("form testForm3 {\n" +
				"demoQuestion: \"Is this really a question?\" boolean\n" +
				"if (demoQuestion) { // WOOOOOOOOW, is this a comment? Yes it is! \n" +
				"	demoQuestion2: \"So this must also be a question then?\" int\n" +
				"	demoQuestion3: \"And this one two?\" int\n" +
				"	/* \n" +
				"	And this also? Yes this one also\n" +
				"	*/ \n" +
				"	if (demoQuestion3 - demoQuestion2 > 17) {\n" +
				"		demoQuestion4: \"What, a question in a if in a if?\" int(demoQuestion2 - demoQuestion3)\n" +
				"	}\n" +
				"	else {\n" +
				"		demoQuestion5: \"There is even an else, really?\" boolean\n" +
				"	}\n" +
				"}\n" +
				"demoQuestion6: \"Is it true?\" boolean" +
				"}").getClass(),Form.class);
	}
	
	@Test
	public void testFormIdents() throws ParseError {
		// Basic form with boolean
		assertTrue(parser.parseForm("" +
				"form testForm1 {\n" +
				"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
				"	if (hasSoldHouse) {\n" +
				"		totalSoldHouseValue: \"How much money did you get for all houses in total?\" int\n" +
				"	}\n" +
				"}").checkFormValidity());
		// Basic form with GT expression over integer
		assertTrue(parser.parseForm("" +
				"form testForm3 {\n" +
				"	hasSoldHouse: \"Have you sold a house in 2012?\" int\n" +
				"	if (hasSoldHouse > 10) {\n" +
				"		totalSoldHouseValue: \"How much money did you get for all houses in total?\" int\n" +
				"	}\n" +
				"}").checkFormValidity());
		// Form with computed questions
		assertTrue(parser.parseForm("" +
				"form testForm1 {\n" +
				"	input1: \"Question irrelevant\" int\n" +
				"	calc1: \"Question irrelevant\" int(10 - 4)\n" +
				"	calc2: \"Question irrelevant\" int(10 - calc1 + input1)\n" +
				"	calc3: \"Question irrelevant\" int(calc1 - calc2)\n" +
				"	calc4: \"Question irrelevant\" int((calc3 + calc2) - (calc1 * 2))\n" +
				"	bool1: \"Question irrelevant\" boolean\n" +
				"	bool2: \"Question irrelevant\" boolean(bool1)\n" +
				"	bool3: \"Question irrelevant\" boolean((10 - 4) < 7 && bool2)\n" +
				"	str1: \"Question irrelevant\" string\n" +
				"	str2: \"Question irrelevant\" string(str1)\n" +
				"	str3: \"Question irrelevant\" string(str2)\n" +
				"}").checkFormValidity());
		// Form with use of variable from outside if
		assertTrue(parser.parseForm("" +
				"form testForm2 {\n" +
				"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
				"	if (hasSoldHouse) {\n" +
				"		totalSoldHouseValue: \"Was house sold?\" boolean(hasSoldHouse)\n" +
				"	}\n" +
				"}").checkFormValidity());
		// Form with use of variable from inside if outside of if
		assertFalse(parser.parseForm("" +
				"form testForm2 {\n" +
				"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
				"	if (hasSoldHouse) {\n" +
				"		totalSoldHouseValue: \"Was house sold?\" int\n" +
				"	}\n" +
				"	if (totalSoldHouseValue > 100000) {\n" +
				"		statement: \"High taxes rate\" boolean(true)\n" +
				"	}\n" +
				"}").checkFormValidity());
		// Form with error if (integer)
		assertFalse(parser.parseForm("" +
				"form testForm2 {\n" +
				"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
				"	if (hasSoldHouse) {\n" +
				"		totalSoldHouseValue: \"How much money did you get for all houses in total?\" int\n" +
				"		if (totalSoldHouseValue) {\n" +
				"			yuRich: \"Do you consider yourself rich?\" boolean\n" +
				"		}\n" +
				"	}\n" +
				"}").checkFormValidity());
		
		// Demo of adding same ident with same types
		assertTrue(parser.parseForm("" +
				"form testform3 {\n" +
				"	ident1: \"int question\" int\n" +
				"	if (true) {\n" +
				"		ident1: \"another int question\" int\n" +
				"	}\n" +
				"}").checkFormValidity());
				
		// Demo of adding same ident with other types
		assertFalse(parser.parseForm("" +
				"form testform3 {\n" +
				"	ident1: \"int question\" int\n" +
				"	if (true) {\n" +
				"		ident1: \"bool question\" boolean\n" +
				"	}\n" +
				"}").checkFormValidity());
				
		// Demo form for error displaying
		Form errorForm = parser.parseForm("" +
				"form errorDemoFrom {\n" +
				"	q1: \"error1\" int(true)\n" +
				"	q2: \"error2\" int(q2 + 1)\n" +
				"	if (q3) {\n" +
				"		q3: \"error3\" boolean\n" +
				"	}\n" +
				"	q3p2: \"Out of scope error\" boolean(q3)" +
				"	if (true) {\n" +
				"		if (true) {\n" +
				"			if (true) {\n" +
				"				q4: \"diep geneste error\" string(1 + \"\")\n" +
				"				q5: \"AllowedTypeDemo of equals\" boolean(q6 == q6)\n" +
				"				q6: \"In scope, no error!\" boolean(q3p2)" +
				"			}\n" +
				"		}\n" +
				"	}\n" +
				"}");
		errorForm.checkFormValidity();
		errorForm.print();
	}
}