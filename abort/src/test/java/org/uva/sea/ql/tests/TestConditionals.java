package org.uva.sea.ql.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.conditionals.IfThen;
import org.uva.sea.ql.ast.conditionals.IfThenElse;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.operators.binary.Eq;
import org.uva.sea.ql.ast.types.datatypes.StringType;

// Test conditionals (if statements)
public class TestConditionals extends TestBase {
	@Test
	public void testIfThen() throws RecognitionException {
		final String expression = "if (0 == 0) { boughtHouse: \"Have you bought this house?\" string }";
		final Node result = parse(expression).ifStatement();
		assertEquals(IfThen.class, result.getClass());

		final Node conditions = ((IfThen) result).getCondition();
		assertNotNull(conditions);
		assertEquals(Eq.class, conditions.getClass());

		final List<Element> successElements = ((IfThen) result)
				.getSuccessElements();
		assertEquals(1, successElements.size());
		assertEquals(Question.class, successElements.get(0).getClass());

		final Question question = (Question) successElements.get(0);
		assertEquals(StringType.class, question.getExpectedType().getClass());

		assertEquals("Have you bought this house?", question.getText());
		assertEquals("boughtHouse", question.getIdent().getName());
	}

	@Test
	public void testIfThenElse() throws RecognitionException {
		final String expression = "if (0 == 0) { boughtHouse: \"Have you bought this house?\" string } else { whyNot: \"Why did you not buy this house?\" string }";
		final Node result = parse(expression).ifStatement();
		assertEquals(IfThenElse.class, result.getClass());

		final Node conditions = ((IfThenElse) result).getCondition();
		assertNotNull(conditions);
		assertEquals(Eq.class, conditions.getClass());

		final List<Element> successElements = ((IfThenElse) result)
				.getSuccessElements();
		assertEquals(1, successElements.size());
		assertEquals(Question.class, successElements.get(0).getClass());

		final Question question = (Question) successElements.get(0);
		assertEquals(StringType.class, question.getExpectedType().getClass());

		assertEquals("Have you bought this house?", question.getText());
		assertEquals("boughtHouse", question.getIdent().getName());

		final List<Element> elseElements = ((IfThenElse) result)
				.getElseElements();
		assertEquals(1, elseElements.size());
		assertEquals(Question.class, elseElements.get(0).getClass());

		final Question elseQuestion = (Question) elseElements.get(0);
		assertEquals(StringType.class, elseQuestion.getExpectedType()
				.getClass());

		assertEquals("whyNot", elseQuestion.getIdent().getName());
		assertEquals("Why did you not buy this house?", elseQuestion.getText());
	}
}
