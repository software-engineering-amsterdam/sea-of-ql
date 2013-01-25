package org.uva.sea.ql.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.*;
import org.uva.sea.ql.parser.jacc.*;
import org.uva.sea.ql.typechecker.TypeChecker;
import org.uva.sea.ql.utils.ASTPrinter;

public class TestTypechecker {
	@Rule public TestWatcher watcher = new TestWatcher() {
		protected void starting(Description description) {
			System.out.println("===================================");
			System.out.println("== " + description.getMethodName());
			System.out.println("===================================");
		};
	};
	
	private Parser parser;
	private TypeChecker checker;

	public TestTypechecker() {
		this.parser = new JACCParser();
		this.checker = new TypeChecker();
	}
	
	// helper method to assert source 's' tests as 'expected'
	private void test(boolean expected, String s) throws ParseException {
		System.out.println("\nSOURCE = \"" + s + "\"");
		ASTNode ast = parser.parse(s);
		ASTPrinter.print(ast, System.out);
		
		boolean result = checker.Check(ast); 
		if (!result) {
			System.err.println(checker.getErrors());
		}
		assertEquals(expected, result);
	}

	@Test
	public void testSymbols() throws ParseException {
		test(true, "form form1 { id1: \"Value?\" integer if (id1 == 3) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { sameid: \"Value?\" integer if (sameid == 3) { sameid: \"Value 2?\" integer } }");
		test(false, "form form1 { q1: \"Value?\" integer if (notusedyet == 3) { q2: \"Value 2?\" integer } }");
		test(false, "form form1 { q1: \"Value?\" integer(notusedyet - 3) }");
		test(false, "form form1 { sameid: \"Value?\" integer if (notusedyet == 3) { sameid: \"Value 2?\" integer } }");

		
	}

	@Test
	public void testLiterals() throws ParseException {
		test(true, "form form1 { id1: \"Value?\" integer(3) }");
		test(false, "form form1 { id1: \"Value?\" integer(true) }");
		test(false, "form form1 { id1: \"Value?\" integer(false) }");
		test(false, "form form1 { id1: \"Value?\" integer(\"abc\") }");
		test(true, "form form1 { id1: \"Value?\" boolean(true) }");
		test(true, "form form1 { id1: \"Value?\" boolean(false) }");
		test(false, "form form1 { id1: \"Value?\" boolean(\"abc\") }");
		test(false, "form form1 { id1: \"Value?\" boolean(123) }");
		test(true, "form form1 { id1: \"Value?\" string(\"abc\") }");
		test(false, "form form1 { id1: \"Value?\" string(123) }");
		test(false, "form form1 { id1: \"Value?\" string(true) }");
		test(false, "form form1 { id1: \"Value?\" string(false) }");
	}

	@Test
	public void testUnaryExpr() throws ParseException {
		test(true, "form form1 { id1: \"Value?\" integer(+3) }");
		test(true, "form form1 { id1: \"Value?\" integer(-3) }");
		test(true, "form form1 { id1: \"Value?\" boolean(!true) }");
		test(true, "form form1 { id1: \"Value?\" boolean(!false) }");
		test(false, "form form1 { id1: \"Value?\" boolean(+true) }");
		test(false, "form form1 { id1: \"Value?\" integer(+false) }");
		test(false, "form form1 { id1: \"Value?\" integer(-true) }");
		test(false, "form form1 { id1: \"Value?\" integer(-false) }");
		test(false, "form form1 { id1: \"Value?\" string(+\"abc\") }");
		test(false, "form form1 { id1: \"Value?\" string(-\"abc\") }");
		test(false, "form form1 { id1: \"Value?\" integer(!3) }");
		test(false, "form form1 { id1: \"Value?\" string(!\"abc\") }");

//		TODO: this results in a 'syntax error' (because of double '}' at the end) which is not a very helpful message
//		test(true, "form form1 { id1: \"Value?\" integer id2: \"Value 2?\" integer(+id1) } }");

		test(true, "form form1 { id1: \"Value?\" integer id2: \"Value 2?\" integer(+id1) }");
		test(true, "form form1 { id1: \"Value?\" integer id2: \"Value 2?\" integer(-id1) }");
		test(false, "form form1 { id1: \"Value?\" integer id2: \"Value 2?\" integer(!id1) }");
		test(false, "form form1 { id1: \"Value?\" boolean id2: \"Value 2?\" integer(+id1) }");
		test(false, "form form1 { id1: \"Value?\" boolean id2: \"Value 2?\" integer(-id1) }");
		test(false, "form form1 { id1: \"Value?\" boolean id2: \"Value 2?\" integer(!id1) }");
		test(true, "form form1 { id1: \"Value?\" boolean id2: \"Value 2?\" boolean(!id1) }");
		test(false, "form form1 { id1: \"Value?\" string id2: \"Value 2?\" integer(+id1) }");
		test(false, "form form1 { id1: \"Value?\" string id2: \"Value 2?\" integer(-id1) }");
		test(false, "form form1 { id1: \"Value?\" string id2: \"Value 2?\" integer(!id1) }");
	}

	@Test
	public void testBinaryExpr() throws ParseException {
		test(true, "form form1 { id1: \"Value?\" integer if (3 == 5) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" integer if (true == false) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" integer if (\"abc\" == \"def\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (true == 5) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (5 == true) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (true == \"abc\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (\"abc\" == true) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (5 == \"abc\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (\"abc\" == 5) { id2: \"Value 2?\" integer } }");

		test(true, "form form1 { id1: \"Value?\" integer if (3 != 5) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" integer if (true != false) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" integer if (\"abc\" != \"def\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (true != 5) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (5 != true) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (true != \"abc\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (\"abc\" != true) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (5 != \"abc\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (\"abc\" != 5) { id2: \"Value 2?\" integer } }");

		test(true, "form form1 { id1: \"Value?\" integer if (3 > 5) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" integer if (\"abc\" > \"def\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (false > true) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (3 > \"abc\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (true > \"abc\") { id2: \"Value 2?\" integer } }");
		
		test(true, "form form1 { id1: \"Value?\" integer if (3 >= 5) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" integer if (\"abc\" >= \"def\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (false >= true) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (3 >= \"abc\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (true >= \"abc\") { id2: \"Value 2?\" integer } }");

		test(true, "form form1 { id1: \"Value?\" integer if (3 < 5) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" integer if (\"abc\" < \"def\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (false < true) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (3 < \"abc\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (true < \"abc\") { id2: \"Value 2?\" integer } }");

		test(true, "form form1 { id1: \"Value?\" integer if (3 <= 5) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" integer if (\"abc\" <= \"def\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (false <= true) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (3 <= \"abc\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (true <= \"abc\") { id2: \"Value 2?\" integer } }");

		test(true, "form form1 { id1: \"Value?\" integer if (true && false) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (123 && 123) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (\"abc\" && \"abc\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (true && 123) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (123 && true) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (true && \"abc\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (\"abc\" && true) { id2: \"Value 2?\" integer } }");

		test(true, "form form1 { id1: \"Value?\" integer if (true || false) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (123 || 123) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (\"abc\" || \"abc\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (true || 123) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (123 || true) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (true || \"abc\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (\"abc\" || true) { id2: \"Value 2?\" integer } }");
	}

	@Test
	public void testCompoundExpr() throws ParseException {
		test(true, "form form1 { id1: \"Value?\" integer if (3 == (5 + 2)) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" integer if (true == (false && true)) { id2: \"Value 2?\" integer } }");
	}

	@Test
	public void testIdentifiers() throws ParseException {
		test(true, "form form1 { id1: \"Value?\" integer if (id1 == 5) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" integer if (5 == id1) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" boolean if (id1 == true) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" boolean if (true == id1) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" boolean if (id1 == false) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" boolean if (false == id1) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" boolean if (id1) { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" string if (id1 == \"abc\") { id2: \"Value 2?\" integer } }");
		test(true, "form form1 { id1: \"Value?\" string if (\"abc\" == id1) { id2: \"Value 2?\" integer } }");

		test(false, "form form1 { id1: \"Value?\" integer if (id1 == true) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" integer if (id1 == \"abc\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" boolean if (id1 == 123) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" boolean if (id1 == \"abc\") { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" string if (id1 == 123) { id2: \"Value 2?\" integer } }");
		test(false, "form form1 { id1: \"Value?\" string if (id1 == true) { id2: \"Value 2?\" integer } }");

//		test(false, "form form1 { id1: \"Value?\" integer(id1) }");
//		test(false, "form form1 { id1: \"Value?\" boolean(id1) }");
//		test(false, "form form1 { id1: \"Value?\" string(id1) }");
		test(true, "form form1 { id1: \"Value?\" integer id2: \"Value 2?\" integer(id1) }");
		test(true, "form form1 { id1: \"Value?\" boolean id2: \"Value 2?\" boolean(id1) }");
		test(true, "form form1 { id1: \"Value?\" string id2: \"Value 2?\" string(id1) }");
		test(false, "form form1 { id1: \"Value?\" integer id2: \"Value 2?\" boolean(id1) }");
		test(false, "form form1 { id1: \"Value?\" integer id2: \"Value 2?\" string(id1) }");
		test(false, "form form1 { id1: \"Value?\" boolean id2: \"Value 2?\" integer(id1) }");
		test(false, "form form1 { id1: \"Value?\" boolean id2: \"Value 2?\" string(id1) }");
		test(false, "form form1 { id1: \"Value?\" string id2: \"Value 2?\" integer(id1) }");
		test(false, "form form1 { id1: \"Value?\" string id2: \"Value 2?\" boolean(id1) }");
	}
}
