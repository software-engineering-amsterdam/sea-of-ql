package org.uva.sea.ql.test.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.AddExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.DivideExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.MultiplyExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.SubtractExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.EqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.GreaterThanExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.GreaterThanOrEqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.LesserThanExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.LesserThanOrEqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.NotEqualExpression;
import org.uva.sea.ql.ast.expression.binary.logical.AndExpression;
import org.uva.sea.ql.ast.expression.binary.logical.OrExpression;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.literal.MoneyLiteral;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.ast.expression.unary.logical.NotExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.NegativeExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.PositiveExpression;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.ExpressionTest;

public class ExpressionParserTest extends ParserTest implements ExpressionTest {
	private enum Side {
		ALL,
		LEFT,
		RIGHT
	};

	private final Parser parser;

	public ExpressionParserTest() {
		super();
		this.parser = this.getParser();
	}

	private void assertExpression( Class<?> expected, String source ) {
		// transform input expression to assignment statement, as atomic expressions do not exist in the QL language.
		source = "x= " + source;
		assertSide( expected, source, Side.RIGHT );
	}

	private void assertSide( Class<?> expected, String source, Side side ) {
		Statement root;

		try {
			root = parser.parse( source );
		}
		catch ( ParseError e ) {
			e.printStackTrace();
			fail( e.getMessage() );
			return;
		}

		Node test = getPartOf( root, side );
		assertEquals( expected, test.getClass() );
	}

	private Node getPartOf( Statement node, Side which ) {
		if ( node instanceof Assignment ) {
			return getPartOf( (Assignment) node, which );
		}

		return node;
	}

	private Node getPartOf( Assignment node, Side which ) {
		switch ( which ) {
			case LEFT:
				return node.getIdentifier();

			case RIGHT:
				return node.getExpression();

			case ALL:
			default:
				return node;
		}
	}

	@Override
	@Test
	public void testAddExpression() {
		assertExpression( AddExpression.class, "a + b" );
		assertExpression( AddExpression.class, "a + b + c" );
		assertExpression( AddExpression.class, "(a + b)" );
		assertExpression( AddExpression.class, "(a + b + c)" );
		assertExpression( AddExpression.class, "(a + b) + c" );
		assertExpression( AddExpression.class, "a + (b + c)" );
		assertExpression( AddExpression.class, "a + b * c" );
		assertExpression( AddExpression.class, "a * b + c" );
		assertExpression( AddExpression.class, "1+1" );
		assertExpression( AddExpression.class, "3+2+1" );
	}

	@Override
	@Test
	public void testSubtractExpression() {
		assertExpression( SubtractExpression.class, "a - b" );
		assertExpression( SubtractExpression.class, "a - b - c" );
		assertExpression( SubtractExpression.class, "(a - b - c)" );
		assertExpression( SubtractExpression.class, "a - (b - c)" );
		assertExpression( SubtractExpression.class, "(a - b) - c" );
		assertExpression( SubtractExpression.class, "(a - b)" );
		assertExpression( SubtractExpression.class, "a - b * c" );
		assertExpression( SubtractExpression.class, "a * b - c" );
		assertExpression( SubtractExpression.class, "1-1" );
	}

	@Override
	@Test
	public void testMultiplyExpression() {
		assertExpression( MultiplyExpression.class, "a * b" );
		assertExpression( MultiplyExpression.class, "a * b * c" );
		assertExpression( MultiplyExpression.class, "a * (b * c)" );
		assertExpression( MultiplyExpression.class, "(a * b) * c" );
		assertExpression( MultiplyExpression.class, "(a * b)" );
		assertExpression( MultiplyExpression.class, "(a + b) * c" );
		assertExpression( MultiplyExpression.class, "a * (b + c)" );
		assertExpression( MultiplyExpression.class, "1*1" );
	}

	@Override
	@Test
	public void testDivideExpression() {
		assertExpression( DivideExpression.class, "a / b" );
		assertExpression( DivideExpression.class, "a / b / c" );
		assertExpression( DivideExpression.class, "a / (b / c)" );
		assertExpression( DivideExpression.class, "(a / b) / c" );
		assertExpression( DivideExpression.class, "(a / b)" );
		assertExpression( DivideExpression.class, "(a + b) / c" );
		assertExpression( DivideExpression.class, "a / (b + c)" );
		assertExpression( DivideExpression.class, "1/1" );
	}

	@Override
	@Test
	public void testLesserThanExpression() {
		// lesser-than
		assertExpression( LesserThanExpression.class, "a < b" );
		assertExpression( LesserThanExpression.class, "a < b + c" );
		assertExpression( LesserThanExpression.class, "a < (b * c)" );
		assertExpression( LesserThanExpression.class, "(a * b) < c" );
	}

	@Override
	@Test
	public void testGreaterThanExpression() {
		// greater-than
		assertExpression( GreaterThanExpression.class, "a > b" );
		assertExpression( GreaterThanExpression.class, "a > b + c" );
		assertExpression( GreaterThanExpression.class, "a > (b * c)" );
		assertExpression( GreaterThanExpression.class, "(a * b) > c" );
	}

	@Override
	@Test
	public void testLesserThanOrEqualExpression() {
		// lesser-than-equals
		assertExpression( LesserThanOrEqualExpression.class, "a <= b" );
		assertExpression( LesserThanOrEqualExpression.class, "a <= b + c" );
		assertExpression( LesserThanOrEqualExpression.class, "a <= (b * c)" );
		assertExpression( LesserThanOrEqualExpression.class, "(a * b) <= c" );
	}

	@Override
	@Test
	public void testGreaterThanOrEqualExpression() {
		// greater-than-equals
		assertExpression( GreaterThanOrEqualExpression.class, "a >= b");
		assertExpression( GreaterThanOrEqualExpression.class, "a >= b + c" );
		assertExpression( GreaterThanOrEqualExpression.class, "a >= (b * c)" );
		assertExpression( GreaterThanOrEqualExpression.class, "(a * b ) >= c" );
	}

	@Override
	@Test
	public void testEqualExpression() {
		// equals
		assertExpression( EqualExpression.class, "a == b" );
		assertExpression( EqualExpression.class, "(a == b)" );
		assertExpression( EqualExpression.class, "a == (b > c)" );
		assertExpression( EqualExpression.class, "a == b + c" );
	}

	@Override
	@Test
	public void testNotEqualExpression() {
		// not-equals
		assertExpression( NotEqualExpression.class, "a != b" );
		assertExpression( NotEqualExpression.class, "(a != b)" );
		assertExpression( NotEqualExpression.class, "a != b + c" );
		assertExpression( NotEqualExpression.class, "a != (b < c)" );
	}

	@Override
	@Test
	public void testIdentifierExpression() {
		assertExpression( IdentifierExpression.class, "a" );
		assertExpression( IdentifierExpression.class, "abc" );
		assertExpression( IdentifierExpression.class, "ABC" );
		assertExpression( IdentifierExpression.class, "ABCdeF" );
		assertExpression( IdentifierExpression.class, "abc2323" );
		assertExpression( IdentifierExpression.class, "a2bc232" );
		assertExpression( IdentifierExpression.class, "a2bc232aa" );
		assertExpression( IdentifierExpression.class, "_bla" );
		assertExpression( IdentifierExpression.class, "a_12bla" );
	}

	@Override
	@Test
	public void testIntegerLiteral() {
		assertExpression( IntegerLiteral.class, "0" );
		assertExpression( IntegerLiteral.class, "1223" );
		assertExpression( IntegerLiteral.class, "234234234" );
	}

	@Override
	@Test
	public void testMoneyLiteral() {
		assertExpression( MoneyLiteral.class, "0.0" );
		assertExpression( MoneyLiteral.class, "0.034982390" );
		assertExpression( MoneyLiteral.class, ".5" );
		assertExpression( MoneyLiteral.class, ".121e-10" );
		assertExpression( MoneyLiteral.class, "141232.12141E+04" );
		assertExpression( MoneyLiteral.class, "1.9e4" );
	}

	@Override
	@Test
	public void testNegativeExpression() {
		assertExpression( NegativeExpression.class, "-1" );
		assertExpression( NegativeExpression.class, "-44320" );
		assertExpression( NegativeExpression.class, "-0" );
		assertExpression( NegativeExpression.class, "-(a * b)" );
	}

	@Override
	@Test
	public void testPositiveExpression() {
		assertExpression( PositiveExpression.class, "+1" );
		assertExpression( PositiveExpression.class, "+0" );
		assertExpression( PositiveExpression.class, "+991821" );
		assertExpression( PositiveExpression.class, "+(-43 * (11 + -3))" );
	}

	@Override
	@Test
	public void testBooleanLiteral() {
		assertExpression( BooleanLiteral.class, "true" );
		assertExpression( BooleanLiteral.class, "false" );
	}

	@Override
	@Test
	public void testStringLiteral() {
		assertExpression( StringLiteral.class, "\"\"" );
		assertExpression( StringLiteral.class, "\"abc\"" );
		assertExpression( StringLiteral.class, "\"321\"" );
		assertExpression( StringLiteral.class, "\"s1t2r3\"" );
		assertExpression( StringLiteral.class, "\"-53\"" );

		// escaped characters
		assertExpression( StringLiteral.class, "\"\\'\"" );
		assertExpression( StringLiteral.class, "\"\\n\"" );
	}

	@Override
	@Test
	public void testAndExpression() {
		assertExpression( AndExpression.class, "a && b" );
		assertExpression( AndExpression.class, "(a && b)" );
		assertExpression( AndExpression.class, "a && (b || c)" );
		assertExpression( AndExpression.class, "a && b && c" );
		assertExpression( AndExpression.class, "a && !b" );
	}

	@Override
	@Test
	public void testOrExpression() {
		assertExpression( OrExpression.class, "a || b" );
		assertExpression( OrExpression.class, "(a || b)" );
		assertExpression( OrExpression.class, "a || b && c" );
		assertExpression( OrExpression.class, "a || (b && c)" );
	}

	@Override
	@Test
	public void testNotExpression() {
		assertExpression( NotExpression.class, "!a" );
		assertExpression( NotExpression.class, "!(a && b)" );
		assertExpression( NotExpression.class, "!(a && !b)" );
		assertExpression( NotExpression.class, "!((a && !b) || !c)" );
	}

	/**
	 * Tests comment structures.
	 */
	@Test
	public void testComments() {
		// multiline
		assertExpression( MultiplyExpression.class, "a /* some comments */ * c" );
		assertExpression( MultiplyExpression.class, "a */**/b" );
		assertExpression( MultiplyExpression.class, "a /** some\nlines\nof\ncomments\n*/\n*c" );
		assertExpression( DivideExpression.class, "a / /**/ b" );

		// single line
		assertExpression( DivideExpression.class, "a / b // something" );
		assertExpression( DivideExpression.class, "a // blablabla\n/b" );
		assertExpression( MultiplyExpression.class, "a *// comments\rd" );
	}
}
