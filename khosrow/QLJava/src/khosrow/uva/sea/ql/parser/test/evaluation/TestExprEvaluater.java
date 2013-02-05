package khosrow.uva.sea.ql.parser.test.evaluation;

import static org.junit.Assert.*;
import khosrow.uva.sea.ql.parser.jacc.JACCParser;
import khosrow.uva.sea.ql.parser.test.IParse;
import khosrow.uva.sea.ql.parser.test.ParseError;
import khosrow.uva.sea.ql.parser.test.TheTestEnv;
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
		//assertEquals(((IntVal)ExprEvaluator.Evaluate(parser.ParseExpression("iA + iB"), TheTestEnv.getTypeEnv())).getValue(), new Integer(3));
		//assertEquals(((IntVal)ExprEvaluator.Evaluate(parser.ParseExpression("iA + 1"), TheTestEnv.getTypeEnv())).getValue(), new Integer(2));
		//assertEquals(((MoneyVal)ExprEvaluator.Evaluate(parser.ParseExpression("iA + mA"), TheTestEnv.getTypeEnv())).getValue(), new Double(2.1));
	}
}
