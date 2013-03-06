package org.uva.sea.ql.parser.test.syntax;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.form.Computed;
import org.uva.sea.ql.ast.form.IfElseStatement;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.parser.antlr.ParseError;

public class FormElementSyntaxTest extends SyntaxTest {

	@Override
	protected Class<?> parseClass(String src) throws ParseError {
		return getParser().parseFormElement(src).getClass();
	}
	
	@Test
	public void testQuestions() throws ParseError {
		assertEquals(Question.class, parseClass("q1: \"fjdslfj\" boolean"));
		assertEquals(Question.class, parseClass("q1: \"\" boolean"));
	}
	

	@Test
	public void testComputedQuestions() throws ParseError {
		assertEquals(Computed.class, parseClass(
				"q1: \"fjdkslfj \" boolean(a == b)"));
		assertEquals(Computed.class, parseClass(
				"q1: \"\" integer(this + that)"));
	}

	@Test
	public void testIfThenElses() throws ParseError {
		assertEquals(IfStatement.class, parseClass(
				"if (d < e) { q1: \" \" integer }"));
		assertEquals(IfStatement.class, parseClass(
				"if (a == b) { } "));
		
		assertEquals(IfElseStatement.class, parseClass(
				"if (d < e) { q1: \" \" integer } else { q2: \" \" string }"));
	}
	
}
