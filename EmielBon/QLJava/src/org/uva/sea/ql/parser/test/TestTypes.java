package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.typechecker.ExpressionChecker;
import org.uva.sea.ql.typechecker.Error;
import org.uva.sea.ql.typechecker.TypeChecker;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class TestTypes {

	private IParse parser;
	
	public TestTypes() {
		this.parser = new JACCParser();
	}
	
	@Test
	public void testExpressionTypes() throws Exception {
		assertTrue(ExpressionChecker.check((Expression) parser.parse("(1 - 2 / 4) * 4"),       new TypeEnvironment(), new ArrayList<Error>()));
		assertTrue(ExpressionChecker.check((Expression) parser.parse("true && false || true"), new TypeEnvironment(), new ArrayList<Error>()));
		assertTrue(ExpressionChecker.check((Expression) parser.parse("(1 - 2 / 4) >= 4"),      new TypeEnvironment(), new ArrayList<Error>()));
		assertTrue(ExpressionChecker.check((Expression) parser.parse("abc"),                   new TypeEnvironment(), new ArrayList<Error>()));
		assertTrue(ExpressionChecker.check((Expression) parser.parse("\"abc\""),               new TypeEnvironment(), new ArrayList<Error>()));
		assertTrue(ExpressionChecker.check((Expression) parser.parse("123"),                   new TypeEnvironment(), new ArrayList<Error>()));
	}
	
	@Test
	public void testStatementTypes() throws Exception {
		assertTrue(TypeChecker.check((Statement)parser.parse("form a { hasSoldHouse:\"Did you sell a house in 2010?\" boolean }")));
		assertTrue(TypeChecker.check((Statement)parser.parse("form a { hasSoldHouse:\"Did you sell a house in 2010?\" boolean\n hasBoughtHouse: \"Did you by a house in 2010?\" integer }")));
		assertTrue(TypeChecker.check((Statement)parser.parse("form a { hasSoldHouse:\"Did you sell a house in 2010?\" boolean\n hasBoughtHouse: \"Did you by a house in 2010?\" boolean(hasSoldHouse) }")));
		assertTrue(TypeChecker.check((Statement) parser.parse(
				"form a { \n" +
				"	hasSoldHouse:\"Did you sell a house in 2010?\" boolean\n" +
				"	hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n" +
				"	if (hasSoldHouse) {\n" +
				"		sellingPrice: \"Price the house was sold for:\" integer(1+2)\n" +
				"	}\n" +
				"}")));
	}
	
}
