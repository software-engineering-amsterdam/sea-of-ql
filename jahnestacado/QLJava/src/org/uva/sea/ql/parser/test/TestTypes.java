package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.visitor.checkers.ExpressionChecker;
import org.uva.sea.ql.visitor.checkers.QLError;

public class TestTypes {

	private ANTLRParser parser;
	private Map<String,Type> declaredVars;
	private List<QLError> errorReport;
	private ExpressionChecker checker;

	public TestTypes() {
		parser = new ANTLRParser();
		errorReport=new ArrayList<QLError>();
		declaredVars=new LinkedHashMap<String,Type>();
		checker=new ExpressionChecker(declaredVars,errorReport);

	}

	@Test
	public void testAllTypes() throws ParseError {
		assertEquals(IntType.class, parser.parseType("int").getClass());
		assertEquals(BoolType.class, parser.parseType("boolean").getClass());
		assertEquals(StringType.class, parser.parseType("string").getClass());
		assertEquals(MoneyType.class, parser.parseType("money").getClass());

	}
	
	
	
	

}