package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Pow;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.expression.value.Int;
import org.uva.sea.ql.ast.expression.value.Money;
import org.uva.sea.ql.ast.expression.value.Str;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JACCParser;

/**
 * Testing expressions.
 */
public class TestParser {
	/**
	 * Holds working parser object.
	 */
	private IParser parser;

	/**
	 * Constructor.
	 */
	public TestParser() {
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
	 * Tests power expressions.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testPows() throws ParseError {
		assertEquals( Pow.class, parser.parse( "a ^ b" ).getClass() );
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
		// integer
		assertEquals( Int.class, parser.parse( "0" ).getClass() );
		assertEquals( Int.class, parser.parse( "1223" ).getClass() );
		assertEquals( Int.class, parser.parse( "234234234" ).getClass() );

		// money
		assertEquals( Money.class, parser.parse( "0.0" ).getClass() );
		assertEquals( Money.class, parser.parse( "0.034982390" ).getClass() );
		assertEquals( Money.class, parser.parse( ".5" ).getClass() );
		assertEquals( Money.class, parser.parse( ".121e-10" ).getClass() );
		assertEquals( Money.class, parser.parse( "141232.12141E+04" ).getClass() );
		assertEquals( Money.class, parser.parse( "1.9e4" ).getClass() );

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
		assertEquals( Str.class, parser.parse( "\"\"" ).getClass() );
		assertEquals( Str.class, parser.parse( "\"abc\"" ).getClass() );
		assertEquals( Str.class, parser.parse( "\"321\"" ).getClass() );
		assertEquals( Str.class, parser.parse( "\"s1t2r3\"" ).getClass() );
		assertEquals( Str.class, parser.parse( "\"-53\"" ).getClass() );

		// escaped characters
		assertEquals( Str.class, parser.parse( "\"\\'\"" ).getClass() );
		assertEquals( Str.class, parser.parse( "\"\\n\"" ).getClass() );
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
		assertEquals( And.class, parser.parse( "a && !b" ).getClass() );

		// logical OR
		assertEquals( Or.class, parser.parse( "a || b" ).getClass() );
		assertEquals( Or.class, parser.parse( "(a || b)" ).getClass() );
		assertEquals( Or.class, parser.parse( "a || b && c" ).getClass() );
		assertEquals( Or.class, parser.parse( "a || (b && c)" ).getClass() );

		// logical NOT
		assertEquals( Not.class, parser.parse( "!a" ).getClass() );
		assertEquals( Not.class, parser.parse( "!(a && b)" ).getClass() );
		assertEquals( Not.class, parser.parse( "!(a && !b)" ).getClass() );
		assertEquals( Not.class, parser.parse( "!((a && !b) || !c)" ).getClass() );
	}

	/**
	 * Tests comment structures.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testComments() throws ParseError {
		// multiline
		assertEquals( Mul.class, parser.parse( "a /* some comments */ * c" ).getClass() );
		assertEquals( Mul.class, parser.parse( "a */**/b" ).getClass() );
		assertEquals( Mul.class, parser.parse( "a /** some\nlines\nof\ncomments\n*/\n*c" ).getClass() );
		assertEquals( Div.class, parser.parse( "a / /**/ b" ).getClass() );

		// single line
		assertEquals( Div.class, parser.parse( "a / b // something" ).getClass() );
		assertEquals( Div.class, parser.parse( "a // blablabla\n/b" ).getClass() );
		assertEquals( Mul.class, parser.parse( "a *// comments\rd" ).getClass() );
	}

	/**
	 * Tests IF-statements.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testIf() throws ParseError {
		// literal conditions
		assertEquals( If.class, parser.parse( "if ( true ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( false ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( 1 ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( \"str\" ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( 131.5e-02 ) { }" ).getClass() );

		// comparison conditions
		assertEquals( If.class, parser.parse( "if ( a == b ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( a != b ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( a >= b ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( a > b ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( a < b ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( a <= b && c ) { }" ).getClass() );

		// arithmetic conditions
		assertEquals( If.class, parser.parse( "if ( 12 + 123 - 1 ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( 0 - 121 + .5 ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( 3 * 55 ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( 100 / 2 ) { }" ).getClass() );

		// logical conditions
		assertEquals( If.class, parser.parse( "if ( true && false ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( a || b ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( b && c ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( a && b || c ) { }" ).getClass() );

		// unary numerical conditions
		assertEquals( If.class, parser.parse( "if ( +22 ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( -22 ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( --9 ) { }" ).getClass() );

		// unary logical conditions
		assertEquals( If.class, parser.parse( "if ( !a ) { }" ).getClass() );
		assertEquals( If.class, parser.parse( "if ( b && !a ) { }" ).getClass() );

		// else-variant
		assertEquals( If.class, parser.parse( "if ( true ) { } else { }" ).getClass() );
	}

	/**
	 * Tests form declarations.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testFormDeclarations() throws ParseError {
		assertEquals( FormDeclaration.class, parser.parse(
			"form ThisForm {" +
			"\t\"What?\" answer : boolean" +
			"}"
		).getClass() );
	}

	/**
	 * Tests question declarations.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testQuestionDeclarations() throws ParseError {
		assertEquals( QuestionDeclaration.class, parser.parse(
			"\"What?\" answer: boolean"
		).getClass() );
	}
}
