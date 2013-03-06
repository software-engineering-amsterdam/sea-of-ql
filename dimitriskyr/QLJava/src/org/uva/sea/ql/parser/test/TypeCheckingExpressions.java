package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.Value;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.visitor.CheckExpr;
import org.uva.sea.ql.visitor.Evaluator;

public class TypeCheckingExpressions {

	private ANTLRParser parser;
	private Map<String, Type> typeEnv;
	private List<String> errormessages;
	private Map<String, Value> env;

	public TypeCheckingExpressions() {
		parser = new ANTLRParser();
		typeEnv = new HashMap<String, Type>();
		errormessages = new ArrayList<String>();
		env = new HashMap<String, Value>();
		new Evaluator(env);
	}

	@Test
	public void testAllTypes() throws ParseError {
		assertEquals(IntegerType.class, parser.parseType("integer").getClass());
		assertEquals(BooleanType.class, parser.parseType("boolean").getClass());
		assertEquals(StringType.class, parser.parseType("string").getClass());
		assertEquals(MoneyType.class, parser.parseType("money").getClass());
	}

	@Test
	public void testExprTypes() throws ParseError {
		assertEquals(false, CheckExpr.check(
				parser.parseExpression("false || true && 0.3"), typeEnv,
				errormessages));
		assertEquals(false, CheckExpr.check(
				parser.parseExpression("(3 && false) && true"), typeEnv,
				errormessages));
		assertEquals(true, CheckExpr.check(
				parser.parseExpression(" false || true "), typeEnv,
				errormessages));
		assertEquals(true, CheckExpr.check(parser.parseExpression("33 == 54"),
				typeEnv, errormessages));
		assertEquals(true, CheckExpr.check(
				parser.parseExpression("76 >= (4 * 65)"), typeEnv,
				errormessages));
		assertEquals(false, CheckExpr.check(
				parser.parseExpression("(33 >= 4) == pao"), typeEnv,
				errormessages));
		assertEquals(true,
				CheckExpr.check(parser.parseExpression("-43.5 + (+24)"),
						typeEnv, errormessages));
	}

}
