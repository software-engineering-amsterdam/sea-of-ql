package org.uva.sea.ql.parser.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.nodevisitor.PrintVisitor;
import org.uva.sea.ql.ast.nodevisitor.PrintVisitorResult;
import org.uva.sea.ql.ast.nodevisitor.SemanticCheckVisitor;

public class TestVisitor extends TestCase {
	static final private IParse parser = new ANTLRParser();

	String a3 = "form DoIt { if ( 10 < 10 ) { fieldTwo : \"hello world!\" money( 10 + 20 ) }}";
	String a4 = "form DoIt { if ( fieldOne == \"StringLit\" ) { fieldTwo : \"hello world!\" money( 10 + 20 ) }}";

	@Test
	public void testPrintVisitor() throws ParseError {
		String expected;
		String actual;
		PrintVisitor pvis = new PrintVisitor();
		QLProgram qlp;

		String a0 = "form DoIt { fieldOne: \"hello world!\" money }";
		qlp = parser.qlprogram(a0);
		expected = ((PrintVisitorResult) qlp.accept(pvis)).getPrintResult();
		qlp = parser.qlprogram(expected);
		actual = ((PrintVisitorResult) qlp.accept(pvis)).getPrintResult();
		assertEquals(expected, actual);

		String a1 = "form DoIt { fieldOne: \"hello world!\" boolean fieldOne1: \"hello world!\" boolean if ( fieldOne1 ) { two: \"is here\" boolean } }";
		qlp = parser.qlprogram(a1);
		expected = ((PrintVisitorResult) qlp.accept(pvis)).getPrintResult();
		qlp = parser.qlprogram(expected);
		actual = ((PrintVisitorResult) qlp.accept(pvis)).getPrintResult();
		assertEquals(expected, actual);

		String a2 = "form DoIt { fieldOne: \"hello world!\" money( 10 + 20 ) }";
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

		String a33 = "form DoIt { field: \"doit\" money if ( field == 100  ) { fieldTwo : \"hello world!\" money( 20 < 20 ) }}";
		qlp = parser.qlprogram(a33);
		qlp.accept(svis);
		for (String errorSting : svis.getErrorList())
			System.out.println(errorSting);
		
		String a34 = "form DoIt { field: \"doit\" money if ( field < 100 ) { fieldTwo : \"hello world!\" money( 20 + 20 ) }}";
		qlp = parser.qlprogram(a34);
		qlp.accept(svis);
		for (String errorSting : svis.getErrorList())
			System.out.println(errorSting);
		
		String a35 = "form DoIt { field: \"doit\" money if ( ( field < 100 )  == true ) { fieldTwo : \"hello world!\" money( 20 + 20 ) }}";
		qlp = parser.qlprogram(a35);
		qlp.accept(svis);
		for (String errorSting : svis.getErrorList())
			System.out.println(errorSting);
		
		String a36 = "form DoIt { field: \"doit\" money if ( field < 100 ) { fieldTwo : \"hello world!\" money( 100 / 20 ) }}";
		qlp = parser.qlprogram(a36);
		qlp.accept(svis);
		for (String errorSting : svis.getErrorList())
			System.out.println(errorSting);
		
		String a37 = "form DoIt { field: \"doit\" boolean if ( field == true && ! false ) { fieldTwo : \"hello world!\" money( 30 + 20 ) }}";
		qlp = parser.qlprogram(a37);
		qlp.accept(svis);
		for (String errorSting : svis.getErrorList())
			System.out.println(errorSting);
		
		String a38 = "form DoIt { field: \"doit\" boolean if ( 100 == 200 && 10 < 100 ) { fieldTwo : \"hello world!\" money( 30 + 20 )  fieldThree : \"third field\" money }}";
		qlp = parser.qlprogram(a38);
		qlp.accept(svis);
		for (String errorSting : svis.getErrorList())
			System.out.println(errorSting);
		
		String a39 = "form DoIt { fieldOne: \"hello world!\" money fieldOne1: \"hello world!\" money if ( true ) { two: \"is here\" boolean } }";
		qlp = parser.qlprogram(a39);
		qlp.accept(svis);
		for (String errorSting : svis.getErrorList())
			System.out.println(errorSting);
	}

}
