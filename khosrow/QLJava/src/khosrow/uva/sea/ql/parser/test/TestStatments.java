package khosrow.uva.sea.ql.parser.test;

import static org.junit.Assert.*;
import khosrow.uva.sea.ql.ast.stmt.ExpressionQuestion;
import khosrow.uva.sea.ql.ast.stmt.SimpleQuestion;
import khosrow.uva.sea.ql.parser.jacc.JACCParser;

import org.junit.Before;
import org.junit.Test;

public class TestStatments {
	private IParse parser;
	
	@Before
	public void startUp(){
		parser = new JACCParser();
	}
	
	@Test
	public void testSimpleQuestion() throws ParseError {
		assertEquals(parser.ParseStatement("Q1 : \"Ask a question?\" string").getClass(), SimpleQuestion.class);
		assertEquals(parser.ParseStatement("Q2 : \"Ask a question?\" integer").getClass(), SimpleQuestion.class);
		assertEquals(parser.ParseStatement("Q3 : \"Ask a question?\" money").getClass(), SimpleQuestion.class);
		assertEquals(parser.ParseStatement("Q4 : \"Ask a question?\" boolean").getClass(), SimpleQuestion.class);		
	}
	
	@Test
	public void testExpressionQuestion() throws ParseError {
		assertEquals(parser.ParseStatement("Q1 ( a > b ) : \"Ask a question?\" string").getClass(), ExpressionQuestion.class);
		assertEquals(parser.ParseStatement("Q1 ( a > b ) : \"Ask a question?\" integer").getClass(), ExpressionQuestion.class);
		assertEquals(parser.ParseStatement("Q1 ( a > b ) : \"Ask a question?\" money").getClass(), ExpressionQuestion.class);
		assertEquals(parser.ParseStatement("Q1 ( a > b ) : \"Ask a question?\" boolean").getClass(), ExpressionQuestion.class);
		assertEquals(parser.ParseStatement("Q1 ( a + b * c / 2 > d - e + f ) : \"Ask a question?\" boolean").getClass(), ExpressionQuestion.class);
	}

}
