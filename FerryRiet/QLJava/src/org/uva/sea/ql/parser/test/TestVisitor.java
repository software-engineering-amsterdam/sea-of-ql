package org.uva.sea.ql.parser.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.astnodevisitor.PrintVisitor;
import org.uva.sea.ql.astnodevisitor.PrintVisitorResult;

public class TestVisitor extends TestCase {
	static final private IParse parser = new ANTLRParser();

	@Test
	public void testvisitor() throws ParseError {
		String expected;
		String actual;
		PrintVisitor pvis = new PrintVisitor();
		QLProgram qlp;

		String a0 = "form DoIt { fieldOne: \"hello world!\" boolean }";
		String a1 = "form DoIt { fieldOne: \"hello world!\" money }";

		qlp = parser.qlprogram(a0);
		expected = ((PrintVisitorResult) qlp.accept(pvis)).getPrintResult();
		qlp = parser.qlprogram(expected);
		actual = ((PrintVisitorResult) qlp.accept(pvis)).getPrintResult();

		assertEquals(expected, actual);

		qlp = parser.qlprogram(a1);
		expected = ((PrintVisitorResult) qlp.accept(pvis)).getPrintResult();
		qlp = parser.qlprogram(expected);
		actual = ((PrintVisitorResult) qlp.accept(pvis)).getPrintResult();

		assertEquals(expected, actual);
	}
}
