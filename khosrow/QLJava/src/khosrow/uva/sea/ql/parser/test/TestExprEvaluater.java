package khosrow.uva.sea.ql.parser.test;

import static org.junit.Assert.*;
import khosrow.uva.sea.ql.parser.jacc.JACCParser;
import khosrow.uva.sea.ql.values.*;
import khosrow.uva.sea.ql.visitor.eval.ExprEvaluator;

import org.junit.Before;
import org.junit.Test;

public class TestExprEvaluater {
	private IParse parser;
	
	@Before
	public void setUp() {
		parser = new JACCParser();
	}
	
	@Test
	public void testAddsVal() throws ParseError {
		assertEquals(((IntVal)ExprEvaluator.Evaluate(parser.ParseExpression("1 + 2"), TheTestEnv.getTypeEnv())).getValue(), new Integer(3));	
		assertEquals(((MoneyVal)ExprEvaluator.Evaluate(parser.ParseExpression("1 + 2.3"), TheTestEnv.getTypeEnv())).getValue(), new Double(3.3));
	}

}
