package khosrow.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;


import khosrow.uva.sea.ql.ast.expr.Add;
import khosrow.uva.sea.ql.ast.expr.And;
import khosrow.uva.sea.ql.ast.expr.GT;
import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.expr.LEq;
import khosrow.uva.sea.ql.ast.expr.LT;
import khosrow.uva.sea.ql.ast.expr.Mul;
import khosrow.uva.sea.ql.ast.expr.Not;
import khosrow.uva.sea.ql.ast.type.Int;
import khosrow.uva.sea.ql.parser.jacc.JACCParser;

import org.junit.Before;
import org.junit.Test;

public class TestExpressions {

	private IParse parser;

	@Before
	public void setUp()
	{
		parser = new JACCParser();
	}

	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.ParseExpression("a + b").getClass(), Add.class);
		assertEquals(parser.ParseExpression("a + b + c").getClass(), Add.class);
		assertEquals(parser.ParseExpression("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.ParseExpression("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.ParseExpression("(a + b) + c").getClass(), Add.class);
		assertEquals(parser.ParseExpression("(a + b)").getClass(), Add.class);
		assertEquals(parser.ParseExpression("a + b * c").getClass(), Add.class);
		assertEquals(parser.ParseExpression("a * b + c").getClass(), Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.ParseExpression("a * b").getClass(), Mul.class);
		assertEquals(parser.ParseExpression("a * b * c").getClass(), Mul.class);
		assertEquals(parser.ParseExpression("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.ParseExpression("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.ParseExpression("(a * b)").getClass(), Mul.class);
		assertEquals(parser.ParseExpression("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.ParseExpression("a * (b + c)").getClass(), Mul.class);
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.ParseExpression("a < b").getClass(), LT.class);
		assertEquals(parser.ParseExpression("a < b + c").getClass(), LT.class);
		assertEquals(parser.ParseExpression("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.ParseExpression("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.ParseExpression("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.ParseExpression("a + b > c").getClass(), GT.class);
		assertEquals(parser.ParseExpression("a > b + c").getClass(), GT.class);
	}
	
	@Test
	public void testBools() throws ParseError {
		assertEquals(parser.ParseExpression("!b").getClass(), Not.class);
		assertEquals(parser.ParseExpression("a && b").getClass(), And.class);
		assertEquals(parser.ParseExpression("a > b && b > c").getClass(), And.class);
		assertEquals(parser.ParseExpression("(a > b) && (b > c)").getClass(), And.class);
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.ParseExpression("a").getClass(), Ident.class);
		assertEquals(parser.ParseExpression("abc").getClass(), Ident.class);
		assertEquals(parser.ParseExpression("ABC").getClass(), Ident.class);
		assertEquals(parser.ParseExpression("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.ParseExpression("abc2323").getClass(), Ident.class);
		assertEquals(parser.ParseExpression("a2bc232").getClass(), Ident.class);
		assertEquals(parser.ParseExpression("a2bc232aa").getClass(), Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.ParseExpression("0").getClass(), Int.class);
		assertEquals(parser.ParseExpression("1223").getClass(), Int.class);
		assertEquals(parser.ParseExpression("234234234").getClass(), Int.class);
	}
}
