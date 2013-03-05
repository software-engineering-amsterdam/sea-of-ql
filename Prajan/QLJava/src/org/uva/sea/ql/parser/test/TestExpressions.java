package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.alg.Add;
import org.uva.sea.ql.ast.alg.GT;
import org.uva.sea.ql.ast.alg.Int;
import org.uva.sea.ql.ast.alg.LEq;
import org.uva.sea.ql.ast.alg.LT;
import org.uva.sea.ql.ast.alg.Mul;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.gen.TypeError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.visitor.CheckExpr;

public class TestExpressions {

	private IParse parser;

	public TestExpressions() {
		this.parser = new ANTLRParser();
	}

	@Test
	public void TestCheckExprAdd() throws ParseError {
		Map<Ident, Type> mp = new HashMap<Ident, Type>();
		mp.put(new Ident("avc"), new org.uva.sea.ql.ast.types.IntType());
		List<TypeError> messages = new ArrayList<TypeError>();
		CheckExpr.check(parser.parse("1 + avc"), mp, messages);
		Assert.assertFalse(messages.isEmpty());
		System.out.println(messages);
	}

	@Test
	public void TestCheckExprDiv() throws ParseError {
		Map<Ident, Type> mp = new HashMap<Ident, Type>();
		mp.put(new Ident("avc"), new org.uva.sea.ql.ast.types.MoneyType());
		CheckExpr.check(parser.parse("1 / 1.2"), mp, null);
	}

	@Test
	public void TestCheckExprAnd() throws ParseError {
		Map<Ident, Type> mp = new HashMap<Ident, Type>();
		mp.put(new Ident("true"), new org.uva.sea.ql.ast.types.BoolType());
		mp.put(new Ident("flase"), new org.uva.sea.ql.ast.types.BoolType());
		CheckExpr.check(parser.parse("true && false"), mp, null);
	}

	@Test
	public void Testform() throws ParseError {
		assertEquals(parser.parse("form test1 {}").getClass(), Add.class);

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
	public void testNums() throws ParseError {
		assertEquals(parser.parse("0").getClass(), Int.class);
		assertEquals(parser.parse("1223").getClass(), Int.class);
		assertEquals(parser.parse("234234234").getClass(), Int.class);
	}

	@Test
	public void testNotExpression() throws ParseError {

		Map<Ident, Type> mp = new HashMap<Ident, Type>();
		mp.put(new Ident("avc"), new org.uva.sea.ql.ast.types.IntType());
		List<TypeError> messages = new ArrayList<TypeError>();
		CheckExpr.check(parser.parse("!111"), mp, messages);
		Assert.assertFalse(messages.isEmpty());
		System.out.println(messages);

	}
}
