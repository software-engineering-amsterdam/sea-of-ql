package org.uva.sea.ql.parser.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.nodevisitor.PrintVisitor;
import org.uva.sea.ql.ast.nodevisitor.PrintVisitorResult;
import org.uva.sea.ql.ast.nodevisitor.TypeCheckVisitor;

public class TestVisitor extends TestCase {
	static final private IParse parser = new ANTLRParser();

	String a3 = "form DoIt { if ( 10 < 10 ) { fieldTwo : \"hello world!\" money( 10 + 20 ) }}";
	String a4 = "form DoIt { if ( fieldOne == \"StringLit\" ) { fieldTwo : \"hello world!\" money( 10 + 20 ) }}";

	@Test
	public void testPrintVisitor() throws ParseError {
		String expected;
		String actual;
		PrintVisitor print = new PrintVisitor();
		QLProgram qlp;

		String a0 = "form DoIt { fieldOne: \"hello world!\" money }";
		qlp = parser.qlprogram(a0);
		expected = ((PrintVisitorResult) qlp.accept(print)).getPrintResult();
		qlp = parser.qlprogram(expected);
		actual = ((PrintVisitorResult) qlp.accept(print)).getPrintResult();
		assertEquals(expected, actual);

		String a1 = "form DoIt { fieldOne: \"hello world!\" boolean fieldOne1: \"hello world!\" boolean if ( fieldOne1 ) { two: \"is here\" boolean } }";
		qlp = parser.qlprogram(a1);
		expected = ((PrintVisitorResult) qlp.accept(print)).getPrintResult();
		qlp = parser.qlprogram(expected);
		actual = ((PrintVisitorResult) qlp.accept(print)).getPrintResult();
		assertEquals(expected, actual);

		String a2 = "form DoIt { fieldOne: \"hello world!\" money( 10 + 20 ) }";
		qlp = parser.qlprogram(a2);
		expected = ((PrintVisitorResult) qlp.accept(print)).getPrintResult();
		qlp = parser.qlprogram(expected);
		actual = ((PrintVisitorResult) qlp.accept(print)).getPrintResult();
		assertEquals(expected, actual);

		qlp = parser.qlprogram(a3);
		expected = ((PrintVisitorResult) qlp.accept(print)).getPrintResult();
		qlp = parser.qlprogram(expected);
		actual = ((PrintVisitorResult) qlp.accept(print)).getPrintResult();
		assertEquals(expected, actual);

		qlp = parser.qlprogram(a4);
		expected = ((PrintVisitorResult) qlp.accept(print)).getPrintResult();
		qlp = parser.qlprogram(expected);
		actual = ((PrintVisitorResult) qlp.accept(print)).getPrintResult();
		assertEquals(expected, actual);
	}

	@Test
	public void testSemanticVisitor() throws ParseError {
		TypeCheckVisitor typeCheck = new TypeCheckVisitor();
		QLProgram qlp;

		String a33 = "form DoIt { field: \"doit\" money if ( field == 100.0  ) { fieldTwo : \"hello world!\" money( 20 < 20 ) }}";
		qlp = parser.qlprogram(a33);
		qlp.accept(typeCheck);
		for (String errorSting : typeCheck.getErrorList())
			System.out.println(errorSting);
		
		String a34 = "form Do { f1: \"a\" money if ( f1 < 100.0 ) { f2 : \"a\" money( f1 + 20 * 1.0 + f2 + 20.0 + 20 * 20 * 20.0 * f1) }}";
		qlp = parser.qlprogram(a34);
		qlp.accept(typeCheck);
		for (String errorSting : typeCheck.getErrorList())
			System.out.println(errorSting);
		
		String a35 = "form DoIt { field: \"doit\" money if ( ( field < 100 )  == true ) { fieldTwo : \"hello world!\" money( 20 + 20 ) }}";
		qlp = parser.qlprogram(a35);
		qlp.accept(typeCheck);
		for (String errorSting : typeCheck.getErrorList())
			System.out.println(errorSting);
		
		String a36 = "form DoIt { field: \"doit\" money if ( field < 100 ) { fieldTwo : \"hello world!\" money( 100 / 20 ) }}";
		qlp = parser.qlprogram(a36);
		qlp.accept(typeCheck);
		for (String errorSting : typeCheck.getErrorList())
			System.out.println(errorSting);
		
		String a37 = "form DoIt { field: \"doit\" boolean if ( field == true && ! false ) { fieldTwo : \"hello world!\" money( 30 + 20 ) }}";
		qlp = parser.qlprogram(a37);
		qlp.accept(typeCheck);
		for (String errorSting : typeCheck.getErrorList())
			System.out.println(errorSting);
		
		String a38 = "form DoIt { field: \"doit\" boolean if ( 100 == 200 && 10 < 100 ) { fieldTwo : \"hello world!\" money( 30 + 20 )  fieldThree : \"third field\" money }}";
		qlp = parser.qlprogram(a38);
		qlp.accept(typeCheck);
		for (String errorSting : typeCheck.getErrorList())
			System.out.println(errorSting);
		
		String a39 = "form DoIt { fieldOne: \"hello world!\" money fieldOne1: \"hello world!\" money if ( true ) { two: \"is here\" boolean } }";
		qlp = parser.qlprogram(a39);
		qlp.accept(typeCheck);
		for (String errorSting : typeCheck.getErrorList())
			System.out.println(errorSting);
	}
}
