package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static com.googlecode.catchexception.CatchException.*;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.jacc.*;

public class TestForms {

	private Parser parser;

	public TestForms() {
		this.parser = new JACCParser();
	}
	
	@Test
	public void testComments() throws ParseException {
		assertEquals(Form.class, parser.parse("form a {b: \"test\" string}/* hello */").getClass());
		assertEquals(Form.class, parser.parse("form a {b: \"test\" string} /* hello */").getClass());
		assertEquals(Form.class, parser.parse("/* hello */form a {b: \"test\" string}").getClass());
		assertEquals(Form.class, parser.parse("/* hello */ form a {b: \"test\" string}").getClass());
		assertEquals(Form.class, parser.parse("form a /* hello */ {b: \"test\" string}").getClass());
		assertEquals(Form.class, parser.parse("form a {b /* hello */ : \"test\" string}").getClass());
		assertEquals(Form.class, parser.parse("form a {b: \"test\" string} /* hello \n world */").getClass());
		assertEquals(Form.class, parser.parse("form a {b: \"test\" string} /* hello \r world */").getClass());
		assertEquals(Form.class, parser.parse("form a {b: \"test\" string} /* hello \n\r world */").getClass());

		assertEquals(Form.class, parser.parse("form a {b: \"test\" string}// hello").getClass());
		assertEquals(Form.class, parser.parse("form a {b: \"test\" string} // hello").getClass());
		assertEquals(Form.class, parser.parse("form a {b: \"test\" string} // hello */").getClass());
		assertEquals(Form.class, parser.parse("form // hello \n a {b: \"test\" string}").getClass());
		assertEquals(Form.class, parser.parse("form // hello \r a {b: \"test\" string}").getClass());
		assertEquals(Form.class, parser.parse("form // hello \n\r a {b: \"test\" string}").getClass());
	}

	@Test
	public void testFormStatements() throws ParseException {
		assertEquals(Form.class, parser.parse("form form1 { question1: \"Name?\" integer }").getClass());
		assertEquals(Form.class, parser.parse("form form1 { question1: \"Name1?\" integer question2: \"Name2?\" string }").getClass());
		assertEquals(Form.class, parser.parse("form form1 { question1: \"Name1?\" integer question2: \"Name2?\" string question3: \"Name3?\" boolean }").getClass());
	}

	@Test
	public void testQuestions() throws ParseException {
		assertEquals(Form.class, parser.parse("form form1 { question1: \"Name?\" integer }").getClass());
		assertEquals(Form.class, parser.parse("form form1 { question1: \"Name?\" string }").getClass());
		assertEquals(Form.class, parser.parse("form form1 { question1: \"Name?\" boolean }").getClass());
		assertEquals(Form.class, parser.parse("form form1 { question1: \"Name1?\" integer question2: \"Name2?\" string }").getClass());
		assertEquals(Form.class, parser.parse("form form1 { question1: \"Name1?\" integer question2: \"Name2?\" string question3: \"Name3?\" boolean }").getClass());

		assertEquals(Form.class, parser.parse("form form1 { question1: \"Name?\" integer(5 - 3)}").getClass());
		assertEquals(Form.class, parser.parse("form form1 { question1: \"Name1?\" integer question2: \"Name2?\" boolean(true && false) }").getClass());
		assertEquals(Form.class, parser.parse("form form1 { question1: \"Name1?\" integer question2: \"Name2?\" boolean(question1 == 3) }").getClass());
	}

	@Test
	public void testDatatypes() throws ParseException {
		assertEquals(Form.class, parser.parse("form form1 { question1: \"Name?\" integer }").getClass());
		assertEquals(Form.class, parser.parse("form form1 { question1: \"Name1?\" string }").getClass());
		assertEquals(Form.class, parser.parse("form form1 { question1: \"Name1?\" boolean }").getClass());
	}

	@Test
	public void testIfs() throws ParseException {
		assertEquals(Form.class, parser.parse("form form1 { q1: \"Value?\" integer if (q1 == 3) { q2: \"Value 2?\" integer } }").getClass());
	}

	@Test
	public void testExtendedForms() throws ParseException {
		assertEquals(Form.class, parser.parse(
				"form Box1HouseOwning {" +
				"	   hasSoldHouse: \"Did you sell a house in 2010?\" boolean" +
				"	   hasBoughtHouse: \"Did you by a house in 2010?\" boolean" +
				"	   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean" +
				"	   if (hasSoldHouse) {" +
				"			 sellingPrice: \"Price the house was sold for:\" integer" +
				"		     privateDebt: \"Private debts for the sold house:\" integer" +
				"		     valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)" +
				"	   }" +
				"}").getClass());
	}

	@Test
	public void testSymbols() throws ParseException {
		verifyException(parser, ParseException.class).parse("form form1 { q1: \"Value?\" integer if (q1 == 3) { q1: \"Value 2?\" integer } }");
		verifyException(parser, ParseException.class).parse("form form1 { q1: \"Value?\" integer if (notusedyet == 3) { q2: \"Value 2?\" integer } }");
		verifyException(parser, ParseException.class).parse("form form1 { q1: \"Value?\" integer(notusedyet - 3) }");
	
	}

}
