package org.uva.sea.ql.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.parser.*;
import org.uva.sea.ql.parser.jacc.*;

public class TestForms {

	private Parser parser;

	public TestForms() {
		this.parser = new JACCParser();
	}
	
	// helper method to assert source 's' returns an AST node of type 'Form'
	private void test(String s) throws ParseException {
		assertEquals(Form.class, parser.parse(s).getClass());
	}
	
	@Test
	public void testComments() throws ParseException {
		test("form a {b: \"test\" string}/* hello */");
		test("form a {b: \"test\" string} /* hello */");
		test("/* hello */form a {b: \"test\" string}");
		test("/* hello */ form a {b: \"test\" string}");
		test("form a /* hello */ {b: \"test\" string}");
		test("form a {b /* hello */ : \"test\" string}");
		test("form a {b: \"test\" string} /* hello \n world */");
		test("form a {b: \"test\" string} /* hello \r world */");
		test("form a {b: \"test\" string} /* hello \n\r world */");

		test("form a {b: \"test\" string}// hello");
		test("form a {b: \"test\" string} // hello");
		test("form a {b: \"test\" string} // hello */");
		test("form // hello \n a {b: \"test\" string}");
		test("form // hello \r a {b: \"test\" string}");
		test("form // hello \n\r a {b: \"test\" string}");
	}

	@Test
	public void testFormStatements() throws ParseException {
		test("form form1 { question1: \"Name?\" integer }");
		test("form form1 { question1: \"Name1?\" integer question2: \"Name2?\" string }");
		test("form form1 { question1: \"Name1?\" integer question2: \"Name2?\" string question3: \"Name3?\" boolean }");
	}

	@Test
	public void testQuestions() throws ParseException {
		test("form form1 { question1: \"Name?\" integer }");
		test("form form1 { question1: \"Name?\" string }");
		test("form form1 { question1: \"Name?\" boolean }");
		test("form form1 { question1: \"Name1?\" integer question2: \"Name2?\" string }");
		test("form form1 { question1: \"Name1?\" integer question2: \"Name2?\" string question3: \"Name3?\" boolean }");

		test("form form1 { question1: \"Name?\" integer(5 - 3)}");
		test("form form1 { question1: \"Name1?\" integer question2: \"Name2?\" boolean(true && false) }");
		test("form form1 { question1: \"Name1?\" integer question2: \"Name2?\" boolean(question1 == 3) }");
	}

	@Test
	public void testDatatypes() throws ParseException {
		test("form form1 { question1: \"Name?\" integer }");
		test("form form1 { question1: \"Name1?\" string }");
		test("form form1 { question1: \"Name1?\" boolean }");
	}

	@Test
	public void testIfs() throws ParseException {
		test("form form1 { q1: \"Value?\" integer if (q1 == 3) { q2: \"Value 2?\" integer } }");
	}

	@Test
	public void testExtendedForms() throws ParseException {
		test(
				"form Box1HouseOwning {" +
				"	   hasSoldHouse: \"Did you sell a house in 2010?\" boolean" +
				"	   hasBoughtHouse: \"Did you by a house in 2010?\" boolean" +
				"	   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean" +
				"	   if (hasSoldHouse) {" +
				"			 sellingPrice: \"Price the house was sold for:\" integer" +
				"		     privateDebt: \"Private debts for the sold house:\" integer" +
				"		     valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)" +
				"	   }" +
				"}");
	}
}
