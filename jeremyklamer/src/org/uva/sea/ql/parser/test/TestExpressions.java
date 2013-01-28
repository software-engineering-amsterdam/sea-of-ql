package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Int;
import org.uva.sea.ql.ast.LT;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.ast.type.Type;
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
		assertEquals(new Integer(32) , ((IntVal)parser.parse("8 * 4").interpret()).getVal());
		assertEquals(new Integer(11) , ((IntVal)parser.parse("1 - 4 / 2 + 12").interpret()).getVal());
		assertEquals(new Integer(45) , ((IntVal)parser.parse("3 - 18 + 15 * 4").interpret()).getVal());
		assertEquals(new Integer(-30) , ((IntVal)parser.parse("(3 - 18) * 2").interpret()).getVal());
		assertEquals(new Integer(-30) , ((IntVal)parser.parse("(3 - 18) * 2").interpret()).getVal());
	}
	
	@Test
	public void testUnaryTypes() throws ParseError {
		Map<Ident, Type> testMap = new HashMap<Ident, Type>();
		assertEquals(0 , parser.parse("3").checkType(testMap).size());
		assertEquals(0 , parser.parse("-3").checkType(testMap).size());
		assertEquals(0 , parser.parse("+3").checkType(testMap).size());
		assertEquals(0 , parser.parse("true").checkType(testMap).size());
		assertEquals(0 , parser.parse("!true").checkType(testMap).size());
		assertEquals(1 , parser.parse("!3").checkType(testMap).size());
		assertEquals(1 , parser.parse("+true").checkType(testMap).size());
		assertEquals(1 , parser.parse("-true").checkType(testMap).size());
	}
	
	@Test
	public void testBinaryTypes() throws ParseError {
		Map<Ident, Type> testMap = new HashMap<Ident, Type>();
		assertEquals(0 , parser.parse("3 + 3").checkType(testMap).size());
		assertEquals(0 , parser.parse("3 * 3").checkType(testMap).size());
		assertEquals(0 , parser.parse("3 / 3").checkType(testMap).size());
		assertEquals(0 , parser.parse("3 - 3").checkType(testMap).size());
		assertEquals(0 , parser.parse("3 <= 3").checkType(testMap).size());
		assertEquals(0 , parser.parse("3 < 3").checkType(testMap).size());
		assertEquals(0 , parser.parse("3 == 3").checkType(testMap).size());
		assertEquals(0 , parser.parse("3 > 3").checkType(testMap).size());
		assertEquals(0 , parser.parse("3 >= 3").checkType(testMap).size());
		assertEquals(0 , parser.parse("3 != 3").checkType(testMap).size());
		assertEquals(0 , parser.parse("true && true").checkType(testMap).size());
		assertEquals(0 , parser.parse("true || true").checkType(testMap).size());
		
		assertEquals(1 , parser.parse("3 + true").checkType(testMap).size());
		assertEquals(1 , parser.parse("3 * true").checkType(testMap).size());
		assertEquals(1 , parser.parse("3 / true").checkType(testMap).size());
		assertEquals(1 , parser.parse("3 - true").checkType(testMap).size());
		assertEquals(1 , parser.parse("3 <= true").checkType(testMap).size());
		assertEquals(1 , parser.parse("3 < true").checkType(testMap).size());
		assertEquals(1 , parser.parse("3 == true").checkType(testMap).size());
		assertEquals(1 , parser.parse("3 > true").checkType(testMap).size());
		assertEquals(1 , parser.parse("3 >= true").checkType(testMap).size());
		assertEquals(1 , parser.parse("3 != true").checkType(testMap).size());
		assertEquals(1 , parser.parse("3 && true").checkType(testMap).size());
		assertEquals(1 , parser.parse("3 || true").checkType(testMap).size());
		
		assertEquals(2 , parser.parse("3 + true * 8 - true + 3").checkType(testMap).size());
	}
	
}
