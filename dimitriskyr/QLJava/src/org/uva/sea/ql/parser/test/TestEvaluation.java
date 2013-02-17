package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.Value;
import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Money;
import org.uva.sea.ql.ast.visitor.Evaluator;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestEvaluation {
	private ANTLRParser parser;
	private Map<Ident, Value> env;
	private Evaluator eval;
	private static final double Delta = 1e-30;
	
	
	public TestEvaluation() {
		parser=new ANTLRParser();
		env = new HashMap<Ident, Value>();
		eval=new Evaluator(env); 
	}
	
	@Test 
 	public void testEvaluation() throws ParseError {
		assertEquals(20 , ((Money) parser.parseExpression("10.5 + 9.5").accept(eval)).getValue(), Delta );
		assertEquals(81 , ((Int) parser.parseExpression("9 * 9").accept(eval)).getValue());
		assertEquals(false , ((Bool) parser.parseExpression("23 == 45").accept(eval)).getValue());
		assertEquals(true , ((Bool) parser.parseExpression("23 == 23").accept(eval)).getValue());
		assertEquals(false , ((Bool) parser.parseExpression("-24 < (-23 - 2)").accept(eval)).getValue());
		assertEquals(47, ((Int) parser.parseExpression("(23+2)*2 -(9/3) ").accept(eval)).getValue());
	}
	
	
}
