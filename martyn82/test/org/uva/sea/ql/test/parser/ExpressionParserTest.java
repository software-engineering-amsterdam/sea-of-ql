package org.uva.sea.ql.test.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.arithmetic.Add;
import org.uva.sea.ql.ast.expression.arithmetic.Div;
import org.uva.sea.ql.ast.expression.arithmetic.Mul;
import org.uva.sea.ql.ast.expression.arithmetic.Sub;
import org.uva.sea.ql.ast.expression.comparison.Eq;
import org.uva.sea.ql.ast.expression.comparison.GEq;
import org.uva.sea.ql.ast.expression.comparison.GT;
import org.uva.sea.ql.ast.expression.comparison.LEq;
import org.uva.sea.ql.ast.expression.comparison.LT;
import org.uva.sea.ql.ast.expression.comparison.NEq;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.ast.expression.logical.And;
import org.uva.sea.ql.ast.expression.logical.Or;
import org.uva.sea.ql.ast.expression.unary.Neg;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Pos;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.IExpressionTest;

public class ExpressionParserTest extends ParserTest implements IExpressionTest {
	private enum Side {
		ALL,
		LEFT,
		RIGHT
	};

	private final IParser parser;

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
				return node.getIdent();

			case RIGHT:
				return node.getExpression();

			case ALL:
			default:
				return node;
		}
	}

	@Override
	@Test
	public void testAdd() {
		assertExpression( Add.class, "a + b" );
		assertExpression( Add.class, "a + b + c" );
		assertExpression( Add.class, "(a + b)" );
		assertExpression( Add.class, "(a + b + c)" );
		assertExpression( Add.class, "(a + b) + c" );
		assertExpression( Add.class, "a + (b + c)" );
		assertExpression( Add.class, "a + b * c" );
		assertExpression( Add.class, "a * b + c" );
		assertExpression( Add.class, "1+1" );
		assertExpression( Add.class, "3+2+1" );
	}

	@Override
	@Test
	public void testSub() {
		assertExpression( Sub.class, "a - b" );
		assertExpression( Sub.class, "a - b - c" );
		assertExpression( Sub.class, "(a - b - c)" );
		assertExpression( Sub.class, "a - (b - c)" );
		assertExpression( Sub.class, "(a - b) - c" );
		assertExpression( Sub.class, "(a - b)" );
		assertExpression( Sub.class, "a - b * c" );
		assertExpression( Sub.class, "a * b - c" );
		assertExpression( Sub.class, "1-1" );
	}

	@Override
	@Test
	public void testMul() {
		assertExpression( Mul.class, "a * b" );
		assertExpression( Mul.class, "a * b * c" );
		assertExpression( Mul.class, "a * (b * c)" );
		assertExpression( Mul.class, "(a * b) * c" );
		assertExpression( Mul.class, "(a * b)" );
		assertExpression( Mul.class, "(a + b) * c" );
		assertExpression( Mul.class, "a * (b + c)" );
		assertExpression( Mul.class, "1*1" );
	}

	@Override
	@Test
	public void testDiv() {
		assertExpression( Div.class, "a / b" );
		assertExpression( Div.class, "a / b / c" );
		assertExpression( Div.class, "a / (b / c)" );
		assertExpression( Div.class, "(a / b) / c" );
		assertExpression( Div.class, "(a / b)" );
		assertExpression( Div.class, "(a + b) / c" );
		assertExpression( Div.class, "a / (b + c)" );
		assertExpression( Div.class, "1/1" );
	}

	@Override
	@Test
	public void testLT() {
		// lesser-than
		assertExpression( LT.class, "a < b" );
		assertExpression( LT.class, "a < b + c" );
		assertExpression( LT.class, "a < (b * c)" );
		assertExpression( LT.class, "(a * b) < c" );
	}

	@Override
	@Test
	public void testGT() {
		// greater-than
		assertExpression( GT.class, "a > b" );
		assertExpression( GT.class, "a > b + c" );
		assertExpression( GT.class, "a > (b * c)" );
		assertExpression( GT.class, "(a * b) > c" );
	}

	@Override
	@Test
	public void testLEq() {
		// lesser-than-equals
		assertExpression( LEq.class, "a <= b" );
		assertExpression( LEq.class, "a <= b + c" );
		assertExpression( LEq.class, "a <= (b * c)" );
		assertExpression( LEq.class, "(a * b) <= c" );
	}

	@Override
	@Test
	public void testGEq() {
		// greater-than-equals
		assertExpression( GEq.class, "a >= b");
		assertExpression( GEq.class, "a >= b + c" );
		assertExpression( GEq.class, "a >= (b * c)" );
		assertExpression( GEq.class, "(a * b ) >= c" );
	}

	@Override
	@Test
	public void testEq() {
		// equals
		assertExpression( Eq.class, "a == b" );
		assertExpression( Eq.class, "(a == b)" );
		assertExpression( Eq.class, "a == (b > c)" );
		assertExpression( Eq.class, "a == b + c" );
	}

	@Override
	@Test
	public void testNEq() {
		// not-equals
		assertExpression( NEq.class, "a != b" );
		assertExpression( NEq.class, "(a != b)" );
		assertExpression( NEq.class, "a != b + c" );
		assertExpression( NEq.class, "a != (b < c)" );
	}

	@Override
	@Test
	public void testId() {
		assertExpression( Ident.class, "a" );
		assertExpression( Ident.class, "abc" );
		assertExpression( Ident.class, "ABC" );
		assertExpression( Ident.class, "ABCdeF" );
		assertExpression( Ident.class, "abc2323" );
		assertExpression( Ident.class, "a2bc232" );
		assertExpression( Ident.class, "a2bc232aa" );
		assertExpression( Ident.class, "_bla" );
		assertExpression( Ident.class, "a_12bla" );
	}

	@Override
	@Test
	public void testInt() {
		assertExpression( Int.class, "0" );
		assertExpression( Int.class, "1223" );
		assertExpression( Int.class, "234234234" );
	}

	@Override
	@Test
	public void testMoney() {
		assertExpression( Money.class, "0.0" );
		assertExpression( Money.class, "0.034982390" );
		assertExpression( Money.class, ".5" );
		assertExpression( Money.class, ".121e-10" );
		assertExpression( Money.class, "141232.12141E+04" );
		assertExpression( Money.class, "1.9e4" );
	}

	@Override
	@Test
	public void testNeg() {
		assertExpression( Neg.class, "-1" );
		assertExpression( Neg.class, "-44320" );
		assertExpression( Neg.class, "-0" );
		assertExpression( Neg.class, "-(a * b)" );
	}

	@Override
	@Test
	public void testPos() {
		assertExpression( Pos.class, "+1" );
		assertExpression( Pos.class, "+0" );
		assertExpression( Pos.class, "+991821" );
		assertExpression( Pos.class, "+(-43 * (11 + -3))" );
	}

	@Override
	@Test
	public void testBool() {
		assertExpression( Bool.class, "true" );
		assertExpression( Bool.class, "false" );
	}

	@Override
	@Test
	public void testStr() {
		assertExpression( Str.class, "\"\"" );
		assertExpression( Str.class, "\"abc\"" );
		assertExpression( Str.class, "\"321\"" );
		assertExpression( Str.class, "\"s1t2r3\"" );
		assertExpression( Str.class, "\"-53\"" );

		// escaped characters
		assertExpression( Str.class, "\"\\'\"" );
		assertExpression( Str.class, "\"\\n\"" );
	}

	@Override
	@Test
	public void testAnd() {
		assertExpression( And.class, "a && b" );
		assertExpression( And.class, "(a && b)" );
		assertExpression( And.class, "a && (b || c)" );
		assertExpression( And.class, "a && b && c" );
		assertExpression( And.class, "a && !b" );
	}

	@Override
	@Test
	public void testOr() {
		assertExpression( Or.class, "a || b" );
		assertExpression( Or.class, "(a || b)" );
		assertExpression( Or.class, "a || b && c" );
		assertExpression( Or.class, "a || (b && c)" );
	}

	@Override
	@Test
	public void testNot() {
		assertExpression( Not.class, "!a" );
		assertExpression( Not.class, "!(a && b)" );
		assertExpression( Not.class, "!(a && !b)" );
		assertExpression( Not.class, "!((a && !b) || !c)" );
	}

	/**
	 * Tests comment structures.
	 */
	@Test
	public void testComments() {
		// multiline
		assertExpression( Mul.class, "a /* some comments */ * c" );
		assertExpression( Mul.class, "a */**/b" );
		assertExpression( Mul.class, "a /** some\nlines\nof\ncomments\n*/\n*c" );
		assertExpression( Div.class, "a / /**/ b" );

		// single line
		assertExpression( Div.class, "a / b // something" );
		assertExpression( Div.class, "a // blablabla\n/b" );
		assertExpression( Mul.class, "a *// comments\rd" );
	}
}
