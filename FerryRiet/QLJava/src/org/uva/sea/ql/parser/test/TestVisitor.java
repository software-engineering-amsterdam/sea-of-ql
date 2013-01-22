package org.uva.sea.ql.parser.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.astnodevisitor.PrintVisitor;
import org.uva.sea.ql.astnodevisitor.PrintVisitorResult;
import org.uva.sea.ql.astnodevisitor.SemanticCheckVisitor;

public class TestVisitor extends TestCase {
	static final private IParse parser = new ANTLRParser();

	String a0 = "form DoIt { fieldOne: \"hello world!\" money }";
	String a1 = "form DoIt { fieldOne: \"hello world!\" boolean fieldOne1: \"hello world!\" boolean if ( fieldOne1 ) { two: \"is here\" boolean } }";
	String a2 = "form DoIt { fieldOne: \"hello world!\" money( 10 + 20 ) }";
	String a3 = "form DoIt { if ( 10 < 10 ) { fieldTwo : \"hello world!\" money( 10 + 20 ) }}";
	String a4 = "form DoIt { if ( fieldOne == \"StringLit\" ) { fieldTwo : \"hello world!\" money( 10 + 20 ) }}";

	@Test
	public void testPrintVisitor() throws ParseError {
		String expected;
		String actual;
		PrintVisitor pvis = new PrintVisitor();
		QLProgram qlp;

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

		qlp = parser.qlprogram(a2);
		expected = ((PrintVisitorResult) qlp.accept(pvis)).getPrintResult();
		qlp = parser.qlprogram(expected);
		actual = ((PrintVisitorResult) qlp.accept(pvis)).getPrintResult();
		assertEquals(expected, actual);

		qlp = parser.qlprogram(a3);
		expected = ((PrintVisitorResult) qlp.accept(pvis)).getPrintResult();
		qlp = parser.qlprogram(expected);
		actual = ((PrintVisitorResult) qlp.accept(pvis)).getPrintResult();
		assertEquals(expected, actual);

		qlp = parser.qlprogram(a4);
		expected = ((PrintVisitorResult) qlp.accept(pvis)).getPrintResult();
		qlp = parser.qlprogram(expected);
		actual = ((PrintVisitorResult) qlp.accept(pvis)).getPrintResult();
		assertEquals(expected, actual);
	}

	@Test
	public void testSemanticVisitor() throws ParseError {
		SemanticCheckVisitor svis = new SemanticCheckVisitor();
		QLProgram qlp;

/*		qlp = parser.qlprogram(a0);
		qlp.accept(svis);
		assertEquals(svis.getErrorReport(), "");

		qlp = parser.qlprogram(a1);
		qlp.accept(svis);
		assertEquals(svis.getErrorReport(), "");
*/
		qlp = parser.qlprogram(a3);
		qlp.accept(svis);
		assertEquals(svis.getErrorReport(), "");
	}

}
