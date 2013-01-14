package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.declaration.VarDeclaration;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.expression.value.Int;
import org.uva.sea.ql.ast.expression.value.Str;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.parser.jacc.JACCParser;

/**
 * Testing expressions.
 */
public class TestExpressions {
	/**
	 * Holds working parser object.
	 */
	private IParser parser;

	/**
	 * Constructor.
	 */
	public TestExpressions() {
		this.parser = new JACCParser();
	}

	/**
	 * Tests addition expressions.
	 * 
	 * @throws ParseError
	 */
	@Test
	public void testAdds() throws ParseError {
		assertEquals( Add.class, parser.parse( "a + b" ).getClass() );
		assertEquals( Add.class, parser.parse( "a + b + c" ).getClass() );
		assertEquals( Add.class, parser.parse( "(a + b)" ).getClass() );
		assertEquals( Add.class, parser.parse( "(a + b + c)" ).getClass() );
		assertEquals( Add.class, parser.parse( "(a + b) + c" ).getClass() );
		assertEquals( Add.class, parser.parse( "a + (b + c)" ).getClass() );
		assertEquals( Add.class, parser.parse( "a + b * c" ).getClass() );
		assertEquals( Add.class, parser.parse( "a * b + c" ).getClass() );
	}
	
	/**
	 * Tests subtraction expressions.
	 * 
	 * @throws ParseError
	 */
	@Test
	public void testSubs() throws ParseError {
		assertEquals( Sub.class, parser.parse( "a - b" ).getClass() );
		assertEquals( Sub.class, parser.parse( "a - b - c" ).getClass() );
		assertEquals( Sub.class, parser.parse( "(a - b - c)" ).getClass() );
		assertEquals( Sub.class, parser.parse( "a - (b - c)" ).getClass() );
		assertEquals( Sub.class, parser.parse( "(a - b) - c" ).getClass() );
		assertEquals( Sub.class, parser.parse( "(a - b)" ).getClass() );
		assertEquals( Sub.class, parser.parse( "a - b * c" ).getClass() );
		assertEquals( Sub.class, parser.parse( "a * b - c" ).getClass() );
	}

	/**
	 * Tests multiplication expressions.
	 * 
	 * @throws ParseError
	 */
	@Test
	public void testMuls() throws ParseError {
		assertEquals( Mul.class, parser.parse( "a * b" ).getClass() );
		assertEquals( Mul.class, parser.parse( "a * b * c" ).getClass() );
		assertEquals( Mul.class, parser.parse( "a * (b * c)" ).getClass() );
		assertEquals( Mul.class, parser.parse( "(a * b) * c" ).getClass() );
		assertEquals( Mul.class, parser.parse( "(a * b)" ).getClass() );
		assertEquals( Mul.class, parser.parse( "(a + b) * c" ).getClass() );
		assertEquals( Mul.class, parser.parse( "a * (b + c)" ).getClass() );
	}
	
	/**
	 * Tests division expressions.
	 * 
	 * @throws ParseError
	 */
	@Test
	public void testDivs() throws ParseError {
		assertEquals( Div.class, parser.parse( "a / b" ).getClass() );
		assertEquals( Div.class, parser.parse( "a / b / c" ).getClass() );
		assertEquals( Div.class, parser.parse( "a / (b / c)" ).getClass() );
		assertEquals( Div.class, parser.parse( "(a / b) / c" ).getClass() );
		assertEquals( Div.class, parser.parse( "(a / b)" ).getClass() );
		assertEquals( Div.class, parser.parse( "(a + b) / c" ).getClass() );
		assertEquals( Div.class, parser.parse( "a / (b + c)" ).getClass() );
	}

	/**
	 * Tests partial order relation expressions.
	 * 
	 * @throws ParseError
	 */
	@Test
	public void testRels() throws ParseError {
		// lesser-than
		assertEquals( LT.class, parser.parse( "a < b" ).getClass() );
		assertEquals( LT.class, parser.parse( "a < b + c" ).getClass() );
		assertEquals( LT.class, parser.parse( "a < (b * c)" ).getClass() );
		assertEquals( LT.class, parser.parse( "(a * b) < c" ).getClass() );
		
		// greater-than
		assertEquals( GT.class, parser.parse( "a > b" ).getClass() );
		assertEquals( GT.class, parser.parse( "a > b + c" ).getClass() );
		assertEquals( GT.class, parser.parse( "a > (b * c)" ).getClass() );
		assertEquals( GT.class, parser.parse( "(a * b) > c" ).getClass() );
		
		// lesser-than-equals
		assertEquals( LEq.class, parser.parse( "a <= b" ).getClass() );
		assertEquals( LEq.class, parser.parse( "a <= b + c" ).getClass() );
		assertEquals( LEq.class, parser.parse( "a <= (b * c)" ).getClass() );
		assertEquals( LEq.class, parser.parse( "(a * b) <= c" ).getClass() );
		
		// greater-than-equals
		assertEquals( GEq.class, parser.parse( "a >= b" ).getClass() );
		assertEquals( GEq.class, parser.parse( "a >= b + c" ).getClass() );
		assertEquals( GEq.class, parser.parse( "a >= (b * c)" ).getClass() );
		assertEquals( GEq.class, parser.parse( "(a * b ) >= c" ).getClass() );
		
		// equals
		assertEquals( Eq.class, parser.parse( "a == b" ).getClass() );
		assertEquals( Eq.class, parser.parse( "(a == b)" ).getClass() );
		assertEquals( Eq.class, parser.parse( "a == (b > c)" ).getClass() );
		assertEquals( Eq.class, parser.parse( "a == b + c" ).getClass() );
		
		// not-equals
		assertEquals( NEq.class, parser.parse( "a != b" ).getClass() );
		assertEquals( NEq.class, parser.parse( "(a != b)" ).getClass() );
		assertEquals( NEq.class, parser.parse( "a != b + c" ).getClass() );
		assertEquals( NEq.class, parser.parse( "a != (b < c)" ).getClass() );
	}

	/**
	 * Tests identifier expressions.
	 * 
	 * @throws ParseError
	 */
	@Test
	public void testIds() throws ParseError {
		assertEquals( Ident.class, parser.parse( "a" ).getClass() );
		assertEquals( Ident.class, parser.parse( "abc" ).getClass() );
		assertEquals( Ident.class, parser.parse( "ABC" ).getClass() );
		assertEquals( Ident.class, parser.parse( "ABCDEF" ).getClass() );
		assertEquals( Ident.class, parser.parse( "abc2323" ).getClass() );
		assertEquals( Ident.class, parser.parse( "a2bc232" ).getClass() );
		assertEquals( Ident.class, parser.parse( "a2bc232aa" ).getClass() );
	}

	/**
	 * Tests numerical literals.
	 * 
	 * @throws ParseError
	 */
	@Test
	public void testNums() throws ParseError {
		assertEquals( Int.class, parser.parse( "0" ).getClass() );
		assertEquals( Int.class, parser.parse( "1223" ).getClass() );
		assertEquals( Int.class, parser.parse( "234234234" ).getClass() );
		
		// negative
		assertEquals( Neg.class, parser.parse( "-1" ).getClass() );
		assertEquals( Neg.class, parser.parse( "-44320" ).getClass() );
		assertEquals( Neg.class, parser.parse( "-0" ).getClass() );
		assertEquals( Neg.class, parser.parse( "-(a * b)" ).getClass() );
		
		// positive
		assertEquals( Pos.class, parser.parse( "+1" ).getClass() );
		assertEquals( Pos.class, parser.parse( "+0" ).getClass() );
		assertEquals( Pos.class, parser.parse( "+991821" ).getClass() );
		assertEquals( Pos.class, parser.parse( "+(-43 * (11 + -3))" ).getClass() );
	}
	
	/**
	 * Tests boolean literals.
	 * 
	 * @throws ParseError
	 */
	@Test
	public void testBools() throws ParseError {
		assertEquals( Bool.class, parser.parse( "true" ).getClass() );
		assertEquals( Bool.class, parser.parse( "false" ).getClass() );
	}
	
	/**
	 * Tests string literals.
	 * 
	 * @throws ParseError
	 */
	@Test
	public void testStrings() throws ParseError {
//		assertEquals( Str.class, parser.parse( "\"\"" ).getClass() );
		assertEquals( Str.class, parser.parse( "\"abc\"" ).getClass() );
//		assertEquals( Str.class, parser.parse( "\"321\"" ).getClass() );
//		assertEquals( Str.class, parser.parse( "\"s1t2r3\"" ).getClass() );
//		assertEquals( Str.class, parser.parse( "\"-53\"" ).getClass() );
	}
	
	/**
	 * Tests logical expressions.
	 * 
	 * @throws ParseError
	 */
	@Test
	public void testLogicals() throws ParseError {
		// logical AND
		assertEquals( And.class, parser.parse( "a && b" ).getClass() );
		assertEquals( And.class, parser.parse( "(a && b)" ).getClass() );
		assertEquals( And.class, parser.parse( "a && (b || c)" ).getClass() );
		assertEquals( And.class, parser.parse( "a && b && c" ).getClass() );
		assertEquals( And.class, parser.parse( "!a && !b" ).getClass() );
		
		// logical OR
		assertEquals( Or.class, parser.parse( "a || b" ).getClass() );
		assertEquals( Or.class, parser.parse( "(a || b)" ).getClass() );
		assertEquals( Or.class, parser.parse( "a || b && c" ).getClass() );
		assertEquals( Or.class, parser.parse( "a || (b && c)" ).getClass() );

		// logical NOT
		assertEquals( Not.class, parser.parse( "!a" ).getClass() );
		assertEquals( Not.class, parser.parse( "!(a && b)" ).getClass() );
	}
	
	/**
	 * Tests comment structures.
	 * 
	 * @throws ParseError
	 */
	@Test
	public void testComments() throws ParseError {
//		assertEquals( Mul.class, parser.parse( "a /* some comments */ * c" ).getClass() );
//		assertEquals( Mul.class, parser.parse( "a */**/b" ).getClass() );
//		assertEquals( Mul.class, parser.parse( "a /** some\nlines\nof\ncomments\n*/\n*c" ).getClass() );
//		assertEquals( Div.class, parser.parse( "a / /**/ b" ).getClass() );

//		assertEquals( Div.class, parser.parse( "a / b // something" ).getClass() );
//		assertEquals( Div.class, parser.parse( "a // blablabla\n/b" ).getClass() );
//		assertEquals( Mul.class, parser.parse( "a *// comments\rd" ).getClass() );
	}
	
	/**
	 * 
	 */
	@Test
	public void testVarDeclaration() throws ParseError {
//		assertEquals( VarDeclaration.class, parser.parse( "isTrue: boolean" ).getClass() );
	}
}
