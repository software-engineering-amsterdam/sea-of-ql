package org.uva.sea.ql.tests.visitor.exprevaluator;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.IntLiteral;
import org.uva.sea.ql.ast.expr.value.MoneyLiteral;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.visitors.rendering.ExprEvaluator;

public class TestIdentExpressions {

	private final Map<String, Value> env = new HashMap<String, Value>();
	private final IParse parser = new ANTLRParser();
	private final ExprEvaluator eval = new ExprEvaluator(env);
	
	@Test
	public void testIdentExpr() throws ParseError {
		env.put(new Ident("Taki").getStringName(), new IntLiteral(10));
		env.put(new Ident("Chan").getStringName(), new IntLiteral(11));
		env.put(new Ident("Ein").getStringName(), new MoneyLiteral(10.00));
		env.put(new Ident("o").getStringName(), new MoneyLiteral(11.00));
		env.put(new Ident("Man").getStringName(), new BoolLiteral(true));
		
		assertEquals( 20 , parser.parseExpr("Taki + Taki").accept(eval).getValue() );
		assertEquals( 21 , parser.parseExpr("Taki + Chan").accept(eval).getValue() );
		assertEquals( 1.00 , parser.parseExpr("o - Ein").accept(eval).getValue() );
		assertEquals( 10.00 , parser.parseExpr("o - o + Ein").accept(eval).getValue() );
		assertEquals( true , parser.parseExpr("((Chan - Taki) >= (Taki - Chan)) == Man ").accept(eval).getValue() );
		assertEquals( false , parser.parseExpr("!Man").accept(eval).getValue() );
	}
	
}
