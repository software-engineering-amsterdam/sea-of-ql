package org.uva.sea.ql.tests;

import static org.junit.Assert.assertEquals;
import static com.googlecode.catchexception.CatchException.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.binary.*;
import org.uva.sea.ql.ast.expression.literal.*;
import org.uva.sea.ql.ast.expression.unary.*;
import org.uva.sea.ql.parser.*;
import org.uva.sea.ql.parser.jacc.*;
import org.uva.sea.ql.utils.ASTPrinter;

public class TestExpressions {
	@Rule public TestWatcher watcher = new TestWatcher() {
		protected void starting(Description description) {
			System.out.println("===================================");
			System.out.println("== " + description.getMethodName());
			System.out.println("===================================");
		};
	};
	
	private Parser parser;

	public TestExpressions() {
		this.parser = new JACCParser();
	}
	
	// helper method to assert source 's' returns an AST node of type 'expected'
	private void test(Object expected, String s) throws ParseException {
		System.out.println("\nSOURCE = \"" + s + "\"");
		ASTNode ast = parser.parse(s);
		ASTPrinter.print(ast, System.out);
		System.out.flush();

		assertEquals(expected, ast.getClass());		
	}
	
	// helper method to verify source 's' throws a RuntimeException (thrown by QLLexer class)
    private void verify(String s) throws ParseException {
		System.out.println("\nSOURCE = \"" + s + "\"");

		verifyException(parser, RuntimeException.class).parse(s);
    }

	@Test
	public void testLexerErrors() throws ParseException {
		verify("&");
		verify("|");
		verify("=");
		verify("\"aa");
	}

	@Test
	public void testUnary() throws ParseException {		
		test(Pos.class, "+a");
		test(Neg.class, "-a");
		test(Not.class, "!a");
	}

	@Test
	public void testBinary() throws ParseException {
		test(Add.class, "a + b");
		test(Div.class, "a / b");
		test(Mul.class, "a * b");
		test(Sub.class, "a - b");

		test(And.class, "a && b");
		test(Or.class, "a || b");
		
		test(GT.class, "a > b");
		test(GEq.class, "a >= b");
		test(LT.class, "a < b");
		test(LEq.class, "a <= b");

		test(Eq.class, "a == b");
		test(NEq.class, "a != b");
	}

	@Test
	public void testAdds() throws ParseException {
		test(Pos.class, "+a");
		test(Add.class, "+b + c + (d + e)");
		test(Add.class, "a + b");
		test(Add.class, "a + b + c");
		test(Add.class, "(a + b + c)");
		test(Add.class, "a + (b + c)");
		test(Add.class, "(a + b) + c");
		test(Add.class, "(a + b)");
		test(Add.class, "a + b * c");
		test(Add.class, "a * b + c");
	}

	@Test
	public void testMuls() throws ParseException {
		test(Mul.class, "a * b");
		test(Mul.class, "a * b * c");
		test(Mul.class, "a * (b * c)");
		test(Mul.class, "(a * b) * c");
		test(Mul.class, "(a * b)");
		test(Mul.class, "(a + b) * c");
		test(Mul.class, "a * (b + c)");
	}

	@Test
	public void testRels() throws ParseException {
		test(LT.class, "a < b");
		test(LT.class, "a < b + c");
		test(LT.class, "a < (b * c)");
		test(LT.class, "(a * b) < c");
		test(LEq.class, "a <= b");
		test(LEq.class, "a <= b + 4");
		test(GT.class, "a + b > c");
		test(GT.class, "a > b + c");
		test(GEq.class, "a >= b");
		test(GEq.class, "a >= b + 4");
		test(Eq.class, "a == b");
		test(Eq.class, "a == b + 4");
		test(NEq.class, "a != b");
		test(NEq.class, "a != b + 4");
	}
	
	@Test
	public void testIds() throws ParseException {
		test(Identifier.class, "a");
		test(Identifier.class, "abc");
		test(Identifier.class, "ABC");
		test(Identifier.class, "ABCDEF");
		test(Identifier.class, "abc2323");
		test(Identifier.class, "a2bc232");
		test(Identifier.class, "a2bc232aa");
	}

	@Test
	public void testInts() throws ParseException {
		test(IntegerLiteral.class, "0");
		test(IntegerLiteral.class, "1223");
		test(IntegerLiteral.class, "234234234");
	}
	
	@Test
	public void testBools() throws ParseException {
		test(Not.class, "!b");
		test(And.class, "a && b");
		test(And.class, "a > b && b > c");
		test(And.class, "(a > b) && (b > c)");
		test(Or.class, "a || b");
		test(Or.class, "a > b || b > c");
		test(Or.class, "(a > b) || (b > c)");
		test(BooleanLiteral.class, "true");
		test(BooleanLiteral.class, "false");
		test(And.class, "true && false");
		test(Or.class, "true || false");
		test(Not.class, "!true");
		test(And.class, "true && a");
		test(And.class, "a && true");
		test(And.class, "false && a");
		test(And.class, "a && false");
		test(Identifier.class, "True");
		test(Identifier.class, "False");
	}

	@Test
	public void testStrings() throws ParseException {
		test(StringLiteral.class, "\"a\"");
		test(StringLiteral.class, "\"aa\"");
		test(StringLiteral.class, "\"abcdefghijklmnop\"");
		test(StringLiteral.class, "\" \"");
		test(StringLiteral.class, "\"\"");
		test(StringLiteral.class, "\"aa\nbbb\"");
		verify("\"aa");
	}
}
