package org.uva.sea.ql.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.conditionals.IfThenElse;
import org.uva.sea.ql.ast.form.Computation;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Label;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.operators.binary.Sub;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StringLiteral;

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
		final Question question = (Question)form.getElements().get(0);
		
		assertEquals(Question.class, question.getClass());
		assertEquals(Bool.class, question.getExpectedType());
		assertEquals("Did you sell a house in 2010?", question.getText());
		assertEquals(new Label("hasSoldHouse"), question.getLabel());		
	}

	private void testQuestion2() {
		final Question question = (Question)form.getElements().get(1);
		
		assertEquals(Question.class, question.getClass());
		assertEquals(Bool.class, question.getExpectedType());
		assertEquals("Did you buy a house in 2010?", question.getText());
		assertEquals(new Label("hasBoughtHouse"), question.getLabel());		
	}

	private void testQuestion3() {
		final Question question = (Question)form.getElements().get(2);

		assertEquals(Question.class, question.getClass());
		assertEquals(Int.class, question.getExpectedType());
		assertEquals("What was the width of the house in meters?", question.getText());
		assertEquals(new Label("width"), question.getLabel());		
	}

	private void testQuestion4() {
		final Question question = (Question)form.getElements().get(3);

		assertEquals(Question.class, question.getClass());
		assertEquals(Int.class, question.getExpectedType());
		assertEquals("What was the length of the house in meters?", question.getText());
		assertEquals(new Label("length"), question.getLabel());		
	}
	
	private void testIfThenElse() {
		final IfThenElse ifThenElse = (IfThenElse)form.getElements().get(4);
		final Node conditions = ifThenElse.getConditions();
		final List<Element> successElements = ifThenElse.getSuccessElements();
		
		assertEquals(Ident.class, conditions.getClass());
		assertEquals("hasSoldHouse", ((Ident)conditions).getName());
		assertEquals(3, successElements.size());
		
		assertEquals(Question.class, successElements.get(0).getClass());

		final Question question1 = (Question)successElements.get(0);
		assertEquals("Price was sold for:", question1.getText());
		assertEquals(new Label("sellingPrice"), question1.getLabel());
		assertEquals(Money.class, question1.getExpectedType());
		
		assertEquals(Question.class, successElements.get(1).getClass());
		
		final Question question2 = (Question)successElements.get(1);
		assertEquals("Private debts for the sold house:", question2.getText());
		assertEquals(new Label("privateDebt"), question2.getLabel());
		assertEquals(Money.class, question2.getExpectedType());
		
		assertEquals(Computation.class, successElements.get(2).getClass());

		// validate the computation which is a subtraction of two idents
		final Computation computation = (Computation)successElements.get(2);
		assertEquals("Value residue:", computation.getDescription());
		assertEquals(new Label("valueResidue"), computation.getLabel());
		assertEquals(Money.class, computation.getExpectedType());
		assertEquals(Sub.class, computation.getCalculationOperation().getClass());

		final Sub sub = (Sub)computation.getCalculationOperation();
		assertEquals(Ident.class, sub.getLeftHandSide().getClass());
		assertEquals(Ident.class, sub.getRightHandSide().getClass());
		assertEquals("sellingPrice", ((Ident)sub.getLeftHandSide()).getName());
		assertEquals("privateDebt", ((Ident)sub.getRightHandSide()).getName());
		
		// test the else flow
		assertEquals(1, ifThenElse.getElseElements().size());
		final Question questionElse = (Question)ifThenElse.getElseElements().get(0);
		assertEquals(StringLiteral.class, questionElse.getExpectedType());
		assertEquals(new Label("reasonNotSelling"), questionElse.getLabel());
		assertEquals("Why did you not sell the house?", questionElse.getText());
	}
	
	@Test
	public void testLabel() {
		// Test the equals and hashcode functionality of label
		final Label labelA = new Label("identicaltag");
		final Label labelB = new Label("identicaltag");
		final Label labelC = new Label("uniquetag");
		assertEquals(labelA, labelB);
		assertEquals(labelA.hashCode(), labelB.hashCode());
		assertFalse(labelA.equals(labelC));
		assertFalse(labelA.hashCode() == labelC.hashCode());
		assertFalse(new Label("").equals(labelA));
	}
}
