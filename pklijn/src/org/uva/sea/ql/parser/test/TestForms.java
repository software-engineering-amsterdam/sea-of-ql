package org.uva.sea.ql.parser.test;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.form.Form;

@RunWith(Parameterized.class)
public class TestForms {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[] {new ANTLRParser()});
		return list;
	}

	
	public TestForms(IParse parser) {
		this.parser = parser;
	}
	
	@Test 
	public void testQuestionForm() throws ParseError {
		assertEquals(parser.parseForm("form testForm1 {\n" +
				"  demoQuestion: \"Is this really a question?\" boolean\n" +
				"}").getClass(),Form.class);
		assertEquals(parser.parseForm("form testForm2 {\n" +
				"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
				"hasBoughtHouse: \"Have you bought a house in 2012?\" string\n" +
				"}").getFormItems().size(),2);
		assertEquals(parser.parseForm("form testForm3 {\n" +
				"demoQuestion: \"Is this really a question?\" boolean\n" +
				"if (demoQuestion) { // WOOOOOOOOW, is this a comment? Yes it is! \n" +
				"	demoQuestion2: \"So this must also be a question then?\" int\n" +
				"	demoQuestion3: \"And this one two?\" int\n" +
				"	/* \n" +
				"	And this also? Yes this one also\n" +
				"	*/ \n" +
				"	if (demoQuestion3) {\n" +
				"		demoQuestion4: \"What, a question in a if in a if?\" int(demoQuestion2 - demoQuestion3)\n" +
				"	}\n" +
				"	else {\n" +
				"		demoQuestion5: \"There is even an else, really?\" boolean\n" +
				"	}\n" +
				"}\n" +
				"demoQuestion6: \"Is it true?\" boolean" +
				"}").getClass(),Form.class);
	}
}