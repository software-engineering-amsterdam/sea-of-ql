package khosrow.uva.sea.ql.parser.test.evaluation;

import static org.junit.Assert.assertEquals;
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
	public void testAdds() throws ParseError {
		assertEquals(((IntVal)ExprEvaluator.Evaluate(parser.ParseExpression("1 + 2"), TheTestEnv.getTypeEnv())).getValue(), new Integer(3));	
		assertEquals(((MoneyVal)ExprEvaluator.Evaluate(parser.ParseExpression("1 + 2.3"), TheTestEnv.getTypeEnv())).getValue(), new Double(3.3));
		assertEquals(((IntVal)ExprEvaluator.Evaluate(parser.ParseExpression("1 - 2"), TheTestEnv.getTypeEnv())).getValue(), new Integer(-1));	
		assertEquals(((MoneyVal)ExprEvaluator.Evaluate(parser.ParseExpression("1 * 2.3"), TheTestEnv.getTypeEnv())).getValue(), new Double(2.3));
		assertEquals(((IntVal)ExprEvaluator.Evaluate(parser.ParseExpression("1 / 2"), TheTestEnv.getTypeEnv())).getValue(), new Integer(1/2));	
		assertEquals(((MoneyVal)ExprEvaluator.Evaluate(parser.ParseExpression("2.3 - 1.0"), TheTestEnv.getTypeEnv())).getValue(), new Double(2.3 - 1.0));
		assertEquals(((IntVal)ExprEvaluator.Evaluate(parser.ParseExpression("iA + iB"), TheTestEnv.getTypeEnv())).getValue(), 
			new Integer(((IntVal)TheTestEnv.getValueOf("iA")).getValue() + ((IntVal)TheTestEnv.getValueOf("iB")).getValue()));				
	}
	
	@Test
	public void testEqs() throws ParseError {
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("1 == 2"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(false));
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("1.1 == 2"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(false));
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("1 == 2.1"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(false));
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("1 == 1"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(true));
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("1.0 == 1"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(true));
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("1.1 == 1.1"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(true));
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("\"Text\" == \"text\""), TheTestEnv.getTypeEnv())).getValue(), new Boolean(true));
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("true == true"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(true));
	}
	
	@Test
	public void testNeqs() throws ParseError {
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("1 != 1"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(false));		
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("1 != 2"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(true));
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("1.1 != 2"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(true));
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("1 != 2.3"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(true));
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("1.34 != 2.34"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(true));	
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("\"Text\" != \"Txt\""), TheTestEnv.getTypeEnv())).getValue(), new Boolean(true));
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("true != true"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(false));
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("false != true"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(true));
	}
	
	@Test
	public void testGeqs() throws ParseError {			
		assertEquals(((BoolVal)ExprEvaluator.Evaluate(parser.ParseExpression("1 >= 2"), TheTestEnv.getTypeEnv())).getValue(), new Boolean(false));
		
					
	}
}