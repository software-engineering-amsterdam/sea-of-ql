package khosrow.uva.sea.ql.parser.test.syntax;

import static org.junit.Assert.assertEquals;

import khosrow.uva.sea.ql.ast.expr.*;
import khosrow.uva.sea.ql.parser.jacc.JACCParser;
import khosrow.uva.sea.ql.parser.test.IParse;
import khosrow.uva.sea.ql.parser.test.ParseError;

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
		assertEquals(parser.ParseExpression("1 * 2 + 3").getClass(), Add.class);
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
		assertEquals(parser.ParseExpression("a || b").getClass(), Or.class);
		assertEquals(parser.ParseExpression("a == b").getClass(), Eq.class);
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
	public void testUnary() throws ParseError{
		assertEquals(parser.ParseExpression("-1").getClass(), Neg.class);
		assertEquals(parser.ParseExpression("-a").getClass(), Neg.class);
		assertEquals(parser.ParseExpression("-abc").getClass(), Neg.class);
		assertEquals(parser.ParseExpression("-(a * b)").getClass(), Neg.class);
		assertEquals(parser.ParseExpression("+1").getClass(), Pos.class);
		assertEquals(parser.ParseExpression("- (( 2 * (-a - b)) / 2)").getClass(), Neg.class);
	}
	
	@Test
	public void testLiterals() throws ParseError{
		assertEquals(parser.ParseExpression("\"A text\"").getClass(), StringLiteral.class);
		assertEquals(parser.ParseExpression("true").getClass(), BoolLiteral.class);
		assertEquals(parser.ParseExpression("false").getClass(), BoolLiteral.class);
		assertEquals(parser.ParseExpression("0").getClass(), IntLiteral.class);
		assertEquals(parser.ParseExpression("1223").getClass(), IntLiteral.class);
		assertEquals(parser.ParseExpression("234234234").getClass(), IntLiteral.class);
		assertEquals(parser.ParseExpression("2333.12332").getClass(), MoneyLiteral.class);
	}
}
