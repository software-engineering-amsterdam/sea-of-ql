package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.And;
import org.uva.sea.ql.ast.Bool;
import org.uva.sea.ql.ast.Div;
import org.uva.sea.ql.ast.Eq;
import org.uva.sea.ql.ast.GEq;
import org.uva.sea.ql.ast.GT;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Int;
import org.uva.sea.ql.ast.LEq;
import org.uva.sea.ql.ast.LT;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.ast.NEq;
import org.uva.sea.ql.ast.Neg;
import org.uva.sea.ql.ast.Not;
import org.uva.sea.ql.ast.Or;
import org.uva.sea.ql.ast.Pos;
import org.uva.sea.ql.ast.Sub;
import org.uva.sea.ql.parser.jacc.JACCParser;

public class TestExpressions {

	private IParse parser;

	public TestExpressions() {
		this.parser = new JACCParser();
	}
	
	@Test
	public void testUnary() throws ParseError {
		assertEquals(Pos.class, parser.parse("+a").getClass());
		assertEquals(Neg.class, parser.parse("-a").getClass());
		assertEquals(Not.class, parser.parse("!a").getClass());
	}

	@Test
	public void testBinary() throws ParseError {
		assertEquals(Add.class, parser.parse("a + b").getClass());
		assertEquals(Div.class, parser.parse("a / b").getClass());
		assertEquals(Mul.class, parser.parse("a * b").getClass());
		assertEquals(Sub.class, parser.parse("a - b").getClass());

		assertEquals(And.class, parser.parse("a && b").getClass());
		assertEquals(Or.class, parser.parse("a || b").getClass());
		
		assertEquals(GT.class, parser.parse("a > b").getClass());
		assertEquals(GEq.class, parser.parse("a >= b").getClass());
		assertEquals(LT.class, parser.parse("a < b").getClass());
		assertEquals(LEq.class, parser.parse("a <= b").getClass());

		assertEquals(Eq.class, parser.parse("a == b").getClass());
		assertEquals(NEq.class, parser.parse("a != b").getClass());
	}

	@Test
	public void testAdds() throws ParseError {
		assertEquals(Pos.class, parser.parse("+a").getClass());
		assertEquals(Add.class, parser.parse("+b + c + (d + e)").getClass());
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
		assertEquals(LEq.class, parser.parse("a <= b").getClass());
		assertEquals(LEq.class, parser.parse("a <= b + 4").getClass());
		assertEquals(GT.class, parser.parse("a + b > c").getClass());
		assertEquals(GT.class, parser.parse("a > b + c").getClass());
		assertEquals(GEq.class, parser.parse("a >= b").getClass());
		assertEquals(GEq.class, parser.parse("a >= b + 4").getClass());
		assertEquals(Eq.class, parser.parse("a == b").getClass());
		assertEquals(Eq.class, parser.parse("a == b + 4").getClass());
		assertEquals(NEq.class, parser.parse("a != b").getClass());
		assertEquals(NEq.class, parser.parse("a != b + 4").getClass());
	}
	
	@Test
	public void testBools() throws ParseError {
		assertEquals(Not.class, parser.parse("!b").getClass());
		assertEquals(And.class, parser.parse("a && b").getClass());
		assertEquals(And.class, parser.parse("a > b && b > c").getClass());
		assertEquals(And.class, parser.parse("(a > b) && (b > c)").getClass());
		assertEquals(Or.class, parser.parse("a || b").getClass());
		assertEquals(Or.class, parser.parse("a > b || b > c").getClass());
		assertEquals(Or.class, parser.parse("(a > b) || (b > c)").getClass());
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
	public void testInts() throws ParseError {
		assertEquals(Int.class, parser.parse("0").getClass());
		assertEquals(Int.class, parser.parse("1223").getClass());
		assertEquals(Int.class, parser.parse("234234234").getClass());
	}
	
	@Test
	public void testSpecific() throws ParseError {
		assertEquals(Bool.class, parser.parse("true").getClass());
		assertEquals(Bool.class, parser.parse("false").getClass());
		assertEquals(And.class, parser.parse("true && false").getClass());
		assertEquals(Or.class, parser.parse("true || false").getClass());
		assertEquals(Not.class, parser.parse("!true").getClass());
		assertEquals(And.class, parser.parse("true && a").getClass());
		assertEquals(And.class, parser.parse("a && true").getClass());
		assertEquals(And.class, parser.parse("false && a").getClass());
		assertEquals(And.class, parser.parse("a && false").getClass());
		assertEquals(Ident.class, parser.parse("True").getClass());
		assertEquals(Ident.class, parser.parse("False").getClass());
	}
}
