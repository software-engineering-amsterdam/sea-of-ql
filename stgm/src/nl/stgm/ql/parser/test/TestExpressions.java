package nl.stgm.ql.parser.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import nl.stgm.ql.parser.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.terminals.*;

public class TestExpressions extends QLTest
{
	private void assertExprClass(Class c, String s) throws ParseError
	{
		assertClass(c, parser.parseExpr(s));
	}

	@Test public void testAdds() throws ParseError
	{
		assertExprClass(Add.class, "a + b");
		assertExprClass(Add.class, "a + b + c");
		assertExprClass(Add.class, "(a + b + c)");
		assertExprClass(Add.class, "a + (b + c)");
		assertExprClass(Add.class, "(a + b) + c");
		assertExprClass(Add.class, "(a + b)");
		assertExprClass(Add.class, "a + b * c");
		assertExprClass(Add.class, "a * b + c");
	}

	@Test public void testSubs() throws ParseError
	{
		assertExprClass(Sub.class, "a - b");
		assertExprClass(Sub.class, "a - b - c");
		assertExprClass(Sub.class, "(a - b - c)");
		assertExprClass(Sub.class, "a - (b + c)");
		assertExprClass(Sub.class, "(a + b) - c");
		assertExprClass(Sub.class, "(a - b)");
		assertExprClass(Sub.class, "a - b * c");
		assertExprClass(Sub.class, "a * b - c");
	}

	@Test public void testMuls() throws ParseError
	{
		assertExprClass(Mul.class, "a * b");
		assertExprClass(Mul.class, "a * b * c");
		assertExprClass(Mul.class, "a * (b * c)");
		assertExprClass(Mul.class, "(a * b) * c");
		assertExprClass(Mul.class, "(a * b)");
		assertExprClass(Mul.class, "(a + b) * c");
		assertExprClass(Mul.class, "a * (b + c)");
	}

	@Test public void testRels() throws ParseError
	{
		assertExprClass(LT.class, "a < b");
		assertExprClass(LT.class, "a < b + c");
		assertExprClass(LT.class, "a < (b * c)");
		assertExprClass(LT.class, "(a * b) < c");
		assertExprClass(LEq.class, "(a <= b)");
		assertExprClass(GT.class, "a + b > c");
		assertExprClass(GT.class, "a > b + c");
	}

	@Test public void testBools() throws ParseError
	{
		assertExprClass(Bool.class, "(true)");
		assertExprClass(Bool.class, "(false)");

		assertEquals(true, ((Bool) parser.parseExpr("(true)")).getValue());
		assertEquals(false, ((Bool) parser.parseExpr("(false)")).getValue());
		
		assertExprClass(Not.class, "!b");
		assertExprClass(And.class, "a && b");
		assertExprClass(And.class, "a > b && b > c");
		assertExprClass(And.class, "(a > b) && (b > c)");
	}
	
	@Test public void testComments() throws ParseError
	{
		assertExprClass(Ident.class, "a // asd");
		assertExprClass(Add.class, "a // asd\n + a");
		assertExprClass(Add.class, "a /* sasa*/ + a");
	}
	
	@Test public void testIds() throws ParseError
	{
		assertExprClass(Ident.class, "a");
		assertExprClass(Ident.class, "abc");
		assertExprClass(Ident.class, "ABC");
		assertExprClass(Ident.class, "ABCDEF");
		assertExprClass(Ident.class, "abc2323");
		assertExprClass(Ident.class, "a2bc232");
		assertExprClass(Ident.class, "a2bc232aa");
	}

	@Test public void testNums() throws ParseError
	{
		assertExprClass(Int.class, "0");
		assertExprClass(Int.class, "1223");
		assertExprClass(Int.class, "234234234");
	}	

	@Test(expected=ParseError.class) public void noEmptyExpr() throws ParseError
	{
		parser.parseExpr("");
	}

	@Test(expected=ParseError.class) public void noSpacing() throws ParseError
	{
		// spacing not allowed at the start of expressions, so no comments either
		parser.parseExpr("// asdk saldk\n1");
	}
}
