package org.uva.sea.ql.parser.test.syntax;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.form.Computed;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.parser.test.ParseError;

public class FormElementTest extends SyntaxTest {

	@Override
	protected Class<?> parseClass(String src) throws ParseError {
		return getParser().parseFormElement(src).getClass();
	}
	
	@Test
	public void testFormElements() throws ParseError {
		assertEquals(parseClass("q1: \"fjdslfj\" boolean"), Question.class);
		assertEquals(parseClass("q1: \"\" boolean"), Question.class);
		
		assertEquals(parseClass("q1: \"fjdkslfj \" boolean(a == b)"), Computed.class);
		assertEquals(parseClass("q1: \"\" integer(this + that)"), Computed.class);
		
		assertEquals(parseClass("if (d < e) { q1: \" \" integer }"), IfStatement.class);
		assertEquals(parseClass("if (a == b) { } "), IfStatement.class);
		
		assertEquals(parseClass(
				"if (d < e) { q1: \" \" integer } else if (a) { }"
				), IfStatement.class);
		assertEquals(parseClass(
				"if (a == b) { } else if (1+1) { }"
				), IfStatement.class);
		
		assertEquals(parseClass(
				"if (d < e) { q1: \" \" integer } else { q2: \" \" string }"
				), IfStatement.class);
		assertEquals(parseClass(
				"if (a == b) { } else if (r == 4) {} else {} "
				), IfStatement.class);
	}

}