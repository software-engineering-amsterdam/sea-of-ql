package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.visitor.checkers.ExpressionChecker;

public class TestTypes {

	private ANTLRParser parser;
	private Map<Ident,Type> declaredVars;
	private List<String> errorReport;
	private ExpressionChecker checker;

	public TestTypes() {
		parser = new ANTLRParser();
		errorReport=new ArrayList<String>();
		declaredVars=new HashMap<Ident,Type>();
		checker=new ExpressionChecker(declaredVars,errorReport);

	}

	@Test
	public void testAllTypes() throws ParseError {
		assertEquals(IntType.class, parser.parseType("int").getClass());
		assertEquals(BoolType.class, parser.parseType("boolean").getClass());
		assertEquals(StringType.class, parser.parseType("string").getClass());
		assertEquals(MoneyType.class, parser.parseType("money").getClass());

	}
	
	@Test
	public void testExprTypes() throws ParseError {
		assertEquals(true, ExpressionChecker.check(parser.parseExpr("(true && false)"),declaredVars, errorReport));
		assertEquals(true, ExpressionChecker.check(parser.parseExpr("(true && false) && true"),declaredVars, errorReport));
		assertEquals(true, ExpressionChecker.check(parser.parseExpr("3==9"),declaredVars, errorReport));
		assertEquals(true, ExpressionChecker.check(parser.parseExpr("(-9==+12) || !(true) && (true == !false) "),declaredVars, errorReport));
		assertEquals(true, ExpressionChecker.check(parser.parseExpr("(!77*(56-12))>=(66/87)"),declaredVars, errorReport));
	

	}
	
	

}