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
import org.uva.sea.ql.visitor.checkers.error.QLErrorMSg;

public class TestExpressionChecker {

		private ANTLRParser parser;
		private Map<String, Type> declaredVars;
		private List<QLErrorMSg> errorReport;

		public TestExpressionChecker() {
			parser = new ANTLRParser();
			errorReport = new ArrayList<QLErrorMSg>();
			declaredVars = new LinkedHashMap<String, Type>();
	
		}

		
		
		@Test
		public void testBoolExprType() throws ParseError {
			declaredVars.put("BoolVar", new BoolType());
			assertEquals(true,ExpressionChecker.check(parser.parseExpr("(4>9) && ((45==3) || BoolVar)"),declaredVars,errorReport));
			assertEquals(false,ExpressionChecker.check(parser.parseExpr("(4>\"UndefinedVar\") && ((45==3) || false)"),declaredVars,errorReport));
			assertEquals(false,ExpressionChecker.check(parser.parseExpr("(4+6) && ((45==3) || false)"),declaredVars,errorReport));
			assertEquals(true,ExpressionChecker.check(parser.parseExpr("(4>=6)!= (((45==3) == false))"),declaredVars,errorReport));
			assertEquals(false,ExpressionChecker.check(parser.parseExpr("(4!=6) &&(((45==3) * !false))"),declaredVars,errorReport));
		}
		
		@Test
		public void testIntExprType() throws ParseError {
			declaredVars.put("IntVar", new IntType());
			assertEquals(true,ExpressionChecker.check(parser.parseExpr("4+IntVar/(3*6-44)"),declaredVars,errorReport));
			assertEquals(false,ExpressionChecker.check(parser.parseExpr("4+\"UndefinedVar\"/(3*6-44)"),declaredVars,errorReport));
			assertEquals(false,ExpressionChecker.check(parser.parseExpr("6+9-2*7.9"),declaredVars,errorReport));
			assertEquals(false,ExpressionChecker.check(parser.parseExpr("6+9-2*!7.9"),declaredVars,errorReport));
            assertEquals(false,ExpressionChecker.check(parser.parseExpr("4+false"),declaredVars,errorReport));
		}
		
		
		@Test
		public void testMoneyExprType() throws ParseError {
			declaredVars.put("type of question", new MoneyType());
			assertEquals(true, ExpressionChecker.check(parser.parseExpr("4.8+9.3/3.2*2.7"),declaredVars, errorReport));
			assertEquals(false, ExpressionChecker.check(parser.parseExpr("4.8+9.3/3.2*!2.7"),declaredVars, errorReport));
			assertEquals(false,ExpressionChecker.check(parser.parseExpr("4.2+3"),declaredVars,errorReport));
			assertEquals(false,ExpressionChecker.check(parser.parseExpr("4.2+false"),declaredVars,errorReport));

		}
		
		
		
		@Test
		public void testStringExprType() throws ParseError {
			declaredVars.put("declaredVariable", new StringType());
			assertEquals(true,ExpressionChecker.check(parser.parseExpr("variable name"),declaredVars,errorReport));
			assertEquals(true,ExpressionChecker.check(parser.parseExpr("\"8+3\""),declaredVars,errorReport));
			assertEquals(false,ExpressionChecker.check(parser.parseExpr("8+3"),declaredVars,errorReport));
		}

	}