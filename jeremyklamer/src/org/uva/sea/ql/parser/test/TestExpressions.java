package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

@RunWith(Parameterized.class)
public class TestExpressions {
	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> retVal = new ArrayList<Object[]>();
		retVal.add(new Object[] {new ANTLRParser()});
		return retVal;
	}
	
	public TestExpressions(IParse parser) {
		this.parser = parser;
	}

	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(Add.class, parser.parse("a + b").getClass());
		assertEquals(Add.class, parser.parse("a + b + c").getClass());
		assertEquals(Add.class, parser.parse("(a + b + c)").getClass());
		assertEquals(Add.class, parser.parse("a + (b + c)").getClass());
		assertEquals(Add.class, parser.parse("(a + b) + c").getClass());
		assertEquals(Add.class, parser.parse("(a + b)").getClass());
		assertEquals(Add.class, parser.parse("a + b * c").getClass());
		assertEquals(Add.class, parser.parse("a * b + c").getClass());
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(Mul.class, parser.parse("a * b").getClass());
		assertEquals(Mul.class, parser.parse("a * b * c").getClass());
		assertEquals(Mul.class, parser.parse("a * (b * c)").getClass());
		assertEquals(Mul.class, parser.parse("(a * b) * c").getClass());
		assertEquals(Mul.class, parser.parse("(a * b)").getClass());
		assertEquals(Mul.class, parser.parse("(a + b) * c").getClass());
		assertEquals(Mul.class, parser.parse("a * (b + c)").getClass());
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(LT.class, parser.parse("a < b").getClass());
		assertEquals(LT.class, parser.parse("a < b + c").getClass());
		assertEquals(LT.class, parser.parse("a < (b * c)").getClass());
		assertEquals(LT.class, parser.parse("(a * b) < c").getClass());
		assertEquals(LT.class, parser.parse("(a < b)").getClass());
		assertEquals(LT.class, parser.parse("a + b < c").getClass());
		assertEquals(LT.class, parser.parse("a < b + c").getClass());
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(Ident.class, parser.parse("a").getClass());
		assertEquals(Ident.class, parser.parse("abc").getClass());
		assertEquals(Ident.class, parser.parse("ABC").getClass());
		assertEquals(Ident.class, parser.parse("ABCDEF").getClass());
		assertEquals(Ident.class, parser.parse("abc2323").getClass());
		assertEquals(Ident.class, parser.parse("a2bc232").getClass());
		assertEquals(Ident.class, parser.parse("a2bc232aa").getClass());
	}
	
	@Test
	public void testNums() throws ParseError {
		assertEquals(Int.class, parser.parse("0").getClass());
		assertEquals(Int.class, parser.parse("1223").getClass());
		assertEquals(Int.class, parser.parse("234234234").getClass());
	}
	
	@Test
	public void testCalcs() throws ParseError {
		assertEquals(Integer.valueOf(32) , ((IntVal)parser.parse("8 * 4").eval(null)).getValue());
		assertEquals(Integer.valueOf(11) , ((IntVal)parser.parse("1 - 4 / 2 + 12").eval(null)).getValue());
		assertEquals(Integer.valueOf(45) , ((IntVal)parser.parse("3 - 18 + 15 * 4").eval(null)).getValue());
		assertEquals(Integer.valueOf(-30) , ((IntVal)parser.parse("(3 - 18) * 2").eval(null)).getValue());
	}
	
	@Test
	public void testUnaryTypes() throws ParseError {
		Env testEnv = new Env(new HashMap<Ident, Type>(),null);
		assertEquals(0 , parser.parse("3").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("-3").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("+3").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("true").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("!true").getTypeErrors(testEnv).size());
		assertEquals(1 , parser.parse("!3").getTypeErrors(testEnv).size());
		assertEquals(1 , parser.parse("+true").getTypeErrors(testEnv).size());
		assertEquals(1 , parser.parse("-true").getTypeErrors(testEnv).size());
	}
	
	@Test
	public void testBinaryTypes() throws ParseError {
		Env testEnv = new Env(new HashMap<Ident, Type>(),null);
		assertEquals(0 , parser.parse("3 + 3").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("3 * 3").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("3 / 3").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("3 - 3").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("3 <= 3").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("3 < 3").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("3 == 3").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("3 > 3").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("3 >= 3").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("3 != 3").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("true && true").getTypeErrors(testEnv).size());
		assertEquals(0 , parser.parse("true || true").getTypeErrors(testEnv).size());
		
		assertEquals(1 , parser.parse("3 + true").getTypeErrors(testEnv).size());
		assertEquals(1 , parser.parse("3 * true").getTypeErrors(testEnv).size());
		assertEquals(1 , parser.parse("3 / true").getTypeErrors(testEnv).size());
		assertEquals(1 , parser.parse("3 - true").getTypeErrors(testEnv).size());
		assertEquals(1 , parser.parse("3 <= true").getTypeErrors(testEnv).size());
		assertEquals(1 , parser.parse("3 < true").getTypeErrors(testEnv).size());
		assertEquals(1 , parser.parse("3 == true").getTypeErrors(testEnv).size());
		assertEquals(1 , parser.parse("3 > true").getTypeErrors(testEnv).size());
		assertEquals(1 , parser.parse("3 >= true").getTypeErrors(testEnv).size());
		assertEquals(1 , parser.parse("3 != true").getTypeErrors(testEnv).size());
		assertEquals(1 , parser.parse("3 && true").getTypeErrors(testEnv).size());
		assertEquals(1 , parser.parse("3 || true").getTypeErrors(testEnv).size());
		assertEquals(2 , parser.parse("3 + true * 8 - true + 3").getTypeErrors(testEnv).size());
	}
	
}
