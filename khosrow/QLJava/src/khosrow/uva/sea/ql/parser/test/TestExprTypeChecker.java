package khosrow.uva.sea.ql.parser.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import khosrow.uva.sea.ql.ast.expr.*;
import khosrow.uva.sea.ql.ast.type.*;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.parser.jacc.JACCParser;
import khosrow.uva.sea.ql.visitor.check.ExprTypeChecker;

import org.junit.Before;
import org.junit.Test;

public class TestExprTypeChecker {
	private IParse parser;
	private static List<QlError> theErrorList() {
		return new ArrayList<QlError>();
	}
	private static Env theEnviroment() {
		Env typeEnv = new Env();		
		typeEnv.declareType(new Ident("iA"), new Int());
		typeEnv.declareType(new Ident("iB"), new Int());
		typeEnv.declareType(new Ident("iC"), new Int());
		typeEnv.declareType(new Ident("iD"), new Int());		
		typeEnv.declareType(new Ident("bA"), new Bool());
		typeEnv.declareType(new Ident("bB"), new Bool());
		typeEnv.declareType(new Ident("bC"), new Bool());
		typeEnv.declareType(new Ident("bD"), new Bool());
		typeEnv.declareType(new Ident("sA"), new Str());
		typeEnv.declareType(new Ident("sB"), new Str());
		typeEnv.declareType(new Ident("sC"), new Str());
		typeEnv.declareType(new Ident("sD"), new Str());
		typeEnv.declareType(new Ident("mA"), new Money());
		typeEnv.declareType(new Ident("mB"), new Money());
		typeEnv.declareType(new Ident("mC"), new Money());
		typeEnv.declareType(new Ident("mD"), new Money());	
		return typeEnv;		
	}
	
	@Before
	public void setUp() {
		parser = new JACCParser();
	}
	
	@Test
	public void testAddsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 + 2.01"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 + 2 + 3 + (1 + 2)"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA + iB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA + mA"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA + mB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mB + iC"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA + 2.01"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA + sB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA + iA"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA + bA"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA + bB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA + 1"), theEnviroment(), theErrorList()), false);
	}
	
	@Test
	public void testSubsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 - 2.01"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 - 2 - 3 - (1 - 2)"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA - iB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA - mA"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA - mB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mB - iC"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA - 2.01"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA - sB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA - iA"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA - bA"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA - bB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA - 1"), theEnviroment(), theErrorList()), false);
	}
	
	@Test
	public void testMulsType() throws ParseError {	
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 * 2.01"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 * 2 * 3 * (1 * 2)"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA * iB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA * mA"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA * mB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mB * iC"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA * 2.01"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA * sB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA * iA"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA * bA"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA * bB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA * 1"), theEnviroment(), theErrorList()), false);
	}
	
	@Test
	public void testDivsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 / 2.01"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 / 2 / 3 / (1 / 2)"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA / iB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA / mA"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA / mB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mB / iC"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA / 2.01"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA / sB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA / iA"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA / bA"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA / bB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA / 1"), theEnviroment(), theErrorList()), false);
	}
	
	@Test
	public void testModsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 % 2.01"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 % 2 % 3 % (1 % 2)"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA % iB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA % mA"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA % mB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mB % iC"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA % 2.01"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA % sB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA % iA"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA % bA"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA % bB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA % 1"), theEnviroment(), theErrorList()), false);
	}
	
	@Test
	public void testAndsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA && bB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true && bA"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA && false"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA && iB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true && iB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA && bA"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA && sB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA && bA"), theEnviroment(), theErrorList()), false);
	}
	
	@Test
	public void testOrsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA || bB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true || bA"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA || false"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA || iB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true || iB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA || bA"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA || sB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA || bA"), theEnviroment(), theErrorList()), false);
	}
	
	@Test
	public void testEqsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA == bB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true == bA"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA == false"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true == false"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA == iB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA == sB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA == mB"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA == iA"), theEnviroment(), theErrorList()), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true == iB"), theEnviroment(), theErrorList()), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA == bA"), theEnviroment(), theErrorList()), false);		
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA == bA"), theEnviroment(), theErrorList()), false);
		
	}

}
