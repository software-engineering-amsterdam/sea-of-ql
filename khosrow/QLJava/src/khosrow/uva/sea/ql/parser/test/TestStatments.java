package khosrow.uva.sea.ql.parser.test;

import static org.junit.Assert.*;
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
		assertEquals(parser.ParseStatement(("Q1 : \"Ask a question?\" string").toString()).getClass(), SimpleQuestion.class);
		assertEquals(parser.ParseStatement(("Q1 : \"Ask a question?\" integer").toString()).getClass(), SimpleQuestion.class);
		assertEquals(parser.ParseStatement(("Q1 : \"Ask a question?\" money").toString()).getClass(), SimpleQuestion.class);
		assertEquals(parser.ParseStatement(("Q1 : \"Ask a question?\" boolean").toString()).getClass(), SimpleQuestion.class);		
	}

}
