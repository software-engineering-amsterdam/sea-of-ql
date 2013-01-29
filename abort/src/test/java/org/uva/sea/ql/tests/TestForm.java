package org.uva.sea.ql.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.conditionals.IfThenElse;
import org.uva.sea.ql.ast.form.Computation;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.operators.binary.Sub;
import org.uva.sea.ql.ast.types.datatypes.BoolType;
import org.uva.sea.ql.ast.types.datatypes.IntType;
import org.uva.sea.ql.ast.types.datatypes.MoneyType;
import org.uva.sea.ql.ast.types.datatypes.StringType;
import org.uva.sea.ql.ast.types.literals.Ident;

public class TestForm extends TestBase {
	private static final String RESOURCE_FORM = "form.ql";
	private Form form;

	@Before
	public void beforeTest() throws RecognitionException, IOException {
		form = parseFormFromResource(RESOURCE_FORM);
	}

	@Test
	public void testFormStructure() throws RecognitionException, IOException {
		assertEquals("Box1HouseOwning", form.getName());
		assertEquals(5, form.getElements().size());

		testQuestion1();
		testQuestion2();
		testQuestion3();
		testQuestion4();
		testIfThenElse();
	}

	private void testQuestion1() {
		final Question question = (Question) form.getElements().get(0);

		assertEquals(Question.class, question.getClass());
		assertEquals(BoolType.class, question.getExpectedType().getClass());
		assertEquals("Did you sell a house in 2010?", question.getText());
		assertEquals(new Ident("hasSoldHouse"), question.getIdent());
	}

	private void testQuestion2() {
		final Question question = (Question) form.getElements().get(1);

		assertEquals(Question.class, question.getClass());
		assertEquals(BoolType.class, question.getExpectedType().getClass());
		assertEquals("Did you buy a house in 2010?", question.getText());
		assertEquals(new Ident("hasBoughtHouse"), question.getIdent());
	}

	private void testQuestion3() {
		final Question question = (Question) form.getElements().get(2);

		assertEquals(Question.class, question.getClass());
		assertEquals(IntType.class, question.getExpectedType().getClass());
		assertEquals("What was the width of the house in meters?",
				question.getText());
		assertEquals(new Ident("width"), question.getIdent());
	}

	private void testQuestion4() {
		final Question question = (Question) form.getElements().get(3);

		assertEquals(Question.class, question.getClass());
		assertEquals(IntType.class, question.getExpectedType().getClass());
		assertEquals("What was the length of the house in meters?",
				question.getText());
		assertEquals(new Ident("length"), question.getIdent());
	}

	private void testIfThenElse() {
		final IfThenElse ifThenElse = (IfThenElse) form.getElements().get(4);
		final Expression conditions = ifThenElse.getCondition();
		final List<Element> successElements = ifThenElse.getSuccessElements();

		assertEquals(Ident.class, conditions.getClass());
		assertEquals("hasSoldHouse", ((Ident) conditions).getName());
		assertEquals(3, successElements.size());

		assertEquals(Question.class, successElements.get(0).getClass());

		final Question question1 = (Question) successElements.get(0);
		assertEquals("Price was sold for:", question1.getText());
		assertEquals(new Ident("sellingPrice"), question1.getIdent());
		assertEquals(MoneyType.class, question1.getExpectedType().getClass());

		assertEquals(Question.class, successElements.get(1).getClass());

		final Question question2 = (Question) successElements.get(1);
		assertEquals("Private debts for the sold house:", question2.getText());
		assertEquals(new Ident("privateDebt"), question2.getIdent());
		assertEquals(MoneyType.class, question2.getExpectedType().getClass());

		assertEquals(Computation.class, successElements.get(2).getClass());

		// validate the computation which is a subtraction of two idents
		final Computation computation = (Computation) successElements.get(2);
		assertEquals("Value residue:", computation.getDescription());
		assertEquals(new Ident("valueResidue"), computation.getIdent());
		assertEquals(MoneyType.class, computation.getExpectedType().getClass());
		assertEquals(Sub.class, computation.getExpression().getClass());

		final Sub sub = (Sub) computation.getExpression();
		assertEquals(Ident.class, sub.getLeftHandSide().getClass());
		assertEquals(Ident.class, sub.getRightHandSide().getClass());
		assertEquals("sellingPrice", ((Ident) sub.getLeftHandSide()).getName());
		assertEquals("privateDebt", ((Ident) sub.getRightHandSide()).getName());

		// test the else flow
		assertEquals(1, ifThenElse.getElseElements().size());
		final Question questionElse = (Question) ifThenElse.getElseElements()
				.get(0);
		assertEquals(StringType.class, questionElse.getExpectedType()
				.getClass());
		assertEquals(new Ident("reasonNotSelling"), questionElse.getIdent());
		assertEquals("Why did you not sell the house?", questionElse.getText());
	}

	@Test
	public void testIdents() {
		// Test the equals and hashcode functionality of label
		final Ident identA = new Ident("identicaltag");
		final Ident identB = new Ident("identicaltag");
		final Ident identC = new Ident("uniquetag");
		assertEquals(identA, identB);
		assertEquals(identA.hashCode(), identB.hashCode());
		assertFalse(identA.equals(identC));
		assertFalse(identA.hashCode() == identC.hashCode());
		assertFalse(new Ident("").equals(identA));
		assertEquals(identA, identA);
		assertFalse(identA.equals(null));
	}
}
