package org.uva.sea.ql.parser.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.*;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

@RunWith(Parameterized.class)
public class Tests {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParser() {
		List<Object[]> parserList = new ArrayList<Object[]>();
		parserList.add(new Object[] { new ANTLRParser() });
		return parserList;
	}

	public Tests(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.parse("a + b").getClass(), Add.class);
		assertEquals(parser.parse("a + b + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.parse("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.parse("(a + b) + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b)").getClass(), Add.class);
		assertEquals(parser.parse("a + b * c").getClass(), Add.class);
		assertEquals(parser.parse("a * b + c").getClass(), Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.parse("a * b").getClass(), Mul.class);
		assertEquals(parser.parse("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parse("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b + c)").getClass(), Mul.class);
	}

	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.parse("a < b").getClass(), LT.class);
		assertEquals(parser.parse("a < b + c").getClass(), LT.class);
		assertEquals(parser.parse("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parse("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parse("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parse("a + b > c").getClass(), GT.class);
		assertEquals(parser.parse("a > b + c").getClass(), GT.class);
	}

	@Test
	public void testBools() throws ParseError {
		assertEquals(parser.parse("!b").getClass(), Not.class);
		assertEquals(parser.parse("a && b").getClass(), And.class);
		assertEquals(parser.parse("a > b && b > c").getClass(), And.class);
		assertEquals(parser.parse("(a > b) && (b > c)").getClass(), And.class);
	}

	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parse("a").getClass(), Ident.class);
		assertEquals(parser.parse("abc").getClass(), Ident.class);
		assertEquals(parser.parse("ABC").getClass(), Ident.class);
		assertEquals(parser.parse("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parse("abc2323").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232aa").getClass(), Ident.class);
	}

	@Test
	public void testInt() throws ParseError {
		assertEquals(parser.parse("0").getClass(), IntLiteral.class);
		assertEquals(parser.parse("1223").getClass(), IntLiteral.class);
		assertEquals(parser.parse("234234234").getClass(), IntLiteral.class);
	}
	
	@Test
	public void testMoney() throws ParseError {
		assertEquals(parser.parse("120.00").getClass(), MoneyLiteral.class);
		assertEquals(parser.parse("1231121.11").getClass(), MoneyLiteral.class);
		assertEquals(parser.parse("00.00").getClass(), MoneyLiteral.class);
	}
	
	@Test
	public void testBoolean() throws ParseError {
		assertEquals(parser.parse("true").getClass(), BoolLiteral.class);
		assertEquals(parser.parse("false").getClass(), BoolLiteral.class);
	}
	
	@Test
	public void testString() throws ParseError {
		assertEquals(parser.parse("\"trues dat\"").getClass(), StringLiteral.class);
		assertEquals(parser.parse("\"true dat\"").getClass(), StringLiteral.class);
		assertEquals(parser.parse("\"true dat\" \" nice to SEE ya\"").getClass(), StringLiteral.class);
		assertEquals(parser.parse("\"True dat\" \n \t \" nice to SEE ya\"").getClass(), StringLiteral.class);
		assertEquals(parser.parse("\"tr<ue **dat\" \" nice) to SEE ya\"").getClass(), StringLiteral.class);
	}
	
	@Test
	public void testComments() throws ParseError {
		assertNull(parser.parse("// \"trues dat\"\n"));
		assertNull(parser.parse("/* true \r \"Dat\" \n 123 */"));
	}
	
	

}
