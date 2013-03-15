package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

@RunWith(Parameterized.class)
// to be able to run same test over again with different values
public class TestForm {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {

		List<Object[]> antlrList = new ArrayList<Object[]>();
		antlrList.add(new Object[] { new ANTLRParser() });
		return antlrList;
	}

	public TestForm(IParse parser) {

		this.parser = parser;
	}

	@Test
	public void TestSingleQuestionForm() throws ParseError {

		assertEquals(Form.class,
				parser.parseForm("from SQForm {question 1: \"How are you doing?\"string}")
						.getClass());
		assertEquals(Form.class,
				parser.parseForm("from SQForm {question 2: \"Are you agree?\"bool}").getClass());
		assertEquals(Form.class,
				parser.parseForm("from SQForm{question 3: \"How old are you?\"int}").getClass());
	}

	@Test
	public void TestIfForm() throws ParseError {

		assertEquals(Form.class, parser.parseForm(
				"form MQForm { " + " question1 : \"Peaceful?\" string "
						+ " question2 : \"how many years?\" int" + " if (!love) { "
						+ " question1 : \"Then what?\" bool "
						+ " question2 : \"...then what?\" string " + " }"
						+ " question3 : \"make frienship\" bool " + " }").getClass());
	}

	@Test
	public void TestNestedIfForm() throws ParseError {

		assertEquals(Form.class, parser.parseForm(
				"form MQForm { " + " question1 : \"Peaceful?\" string "
						+ " question2 : \"how many years\" int" + " if (!love) { "
						+ " question4 : \"Then what?\" bool " + " if (love * 4) { "
						+ " question6 : \" wtf? \" int " + " }"
						+ " question5 : \"...then what?\" string"
						+ " if (true + false * peace / 9898) { "
						+ " question7 : \" bla bla \" int " + " if (question2 + question6 ) { "
						+ " question8 : \" lekker \" string " + " question9 : \" joli \" bool "
						+ " }" + " }" + " }" + " question3 : \"again question?\" bool " + " }")
				.getClass());
	}

	@Test
	public void TestSampleForm() throws ParseError {

		assertEquals(
				Form.class,
				parser.parseForm(
						"form Box1HouseOwning { "
								+ " hasSoldHouse: \"Did you sell a house in 2012? \" bool "
								+ " hasBoughtHouse: \"Did you by a house in 2012? \" bool "
								+ " hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction? \" bool "
								+ " if (hasSoldHouse) {"
								+ " sellingPrice: \"Price the house was sold for:\" int "
								+ " privateDebt: \"Private debts for the sold house:\" int "
								+ " valueResidue: \"Value residue:\" int (sellingPrice - privateDebt)"
								+ " }" + " }").getClass());
	}
}
