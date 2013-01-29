package org.uva.sea.ql.test.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Node;
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
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.test.IExpressionTest;

/**
 * Testing expressions.
 */
public class TestParser implements IExpressionTest {
	/**
	 * Enumeration of which side to pick in an expression or statement.
	 */
	private enum Side {
		ALL,
		LEFT,
		RIGHT
	};

	/**
	 * Holds working parser object.
	 */
	private IParser parser;

	/**
	 * Constructs a new instance of the parser test.
	 */
	public TestParser() {
		this.parser = new JACCParser();
	}

	/**
	 * Shorthand method for asserting an expression source.
	 *
	 * @param expected
	 * @param source
	 */
	private void assertExpression( Class<?> expected, String source ) {
		// transform input expression to assignment statement, as atomic expressions do not exist in the language.
		source = "x= " + source;
		assertSide( expected, source, Side.RIGHT );
	}

	/**
	 * Shorthand method for asserting a node type.
	 *
	 * @param expected
	 * @param source
	 */
	private void assertNode( Class<?> expected, String source ) {
		Statement root;

		try {
			root = parser.parse( source );
		}
		catch ( ParseError e ) {
			e.printStackTrace();
			return;
		}

		assertEquals( expected, root.getClass() );
	}

	/**
	 * Assert a side of a Node is of a certain type.
	 *
	 * @param expected
	 * @param source
	 * @param side
	 */
	private void assertSide( Class<?> expected, String source, Side side ) {
		Statement root;

		try {
			root = parser.parse( source );
		}
		catch ( ParseError e ) {
			e.printStackTrace();
			return;
		}

		Node test = getPartOf( root, side );
		assertEquals( expected, test.getClass() );
	}

	/**
	 * Retrieves a part of a statement.
	 *
	 * @param node
	 * @param which
	 *
	 * @return The node type it represents.
	 */
	private Node getPartOf( Statement node, Side which ) {
		if ( node instanceof Assignment ) {
			return getPartOf( (Assignment) node, which );
		}

		return node;
	}

	/**
	 * Retrieves a part of an assignment node.
	 *
	 * @param node
	 * @param which
	 *
	 * @return The node at the given part.
	 */
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

	@Test
	public void testId() {
		assertExpression( Ident.class, "a" );
		assertExpression( Ident.class, "abc" );
		assertExpression( Ident.class, "ABC" );
		assertExpression( Ident.class, "ABCdeF" );
		assertExpression( Ident.class, "abc2323" );
		assertExpression( Ident.class, "a2bc232" );
		assertExpression( Ident.class, "a2bc232aa" );
	}

	@Test
	public void testInt() {
		assertExpression( Int.class, "0" );
		assertExpression( Int.class, "1223" );
		assertExpression( Int.class, "234234234" );
	}

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

	@Test
	public void testBool() {
		assertExpression( Bool.class, "true" );
		assertExpression( Bool.class, "false" );
	}

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

	/**
	 * Tests IF-statements.
	 */
	@Test
	public void testIf() {
		// literal conditions
		assertNode( IfThenElse.class, "if ( true ) { }" );
		assertNode( IfThenElse.class, "if ( false ) { }" );
		assertNode( IfThenElse.class, "if ( 1 ) { }" );
		assertNode( IfThenElse.class, "if ( \"str\" ) { }" );
		assertNode( IfThenElse.class, "if ( 131.5e-02 ) { }" );

		// comparison conditions
		assertNode( IfThenElse.class, "if ( a == b ) { }" );
		assertNode( IfThenElse.class, "if ( a != b ) { }" );
		assertNode( IfThenElse.class, "if ( a >= b ) { }" );
		assertNode( IfThenElse.class, "if ( a > b ) { }" );
		assertNode( IfThenElse.class, "if ( a < b ) { }" );
		assertNode( IfThenElse.class, "if ( a <= b && c ) { }" );

		// arithmetic conditions
		assertNode( IfThenElse.class, "if ( 12 + 123 - 1 ) { }" );
		assertNode( IfThenElse.class, "if ( 0 - 121 + .5 ) { }" );
		assertNode( IfThenElse.class, "if ( 3 * 55 ) { }" );
		assertNode( IfThenElse.class, "if ( 100 / 2 ) { }" );

		// logical conditions
		assertNode( IfThenElse.class, "if ( true && false ) { }" );
		assertNode( IfThenElse.class, "if ( a || b ) { }" );
		assertNode( IfThenElse.class, "if ( b && c ) { }" );
		assertNode( IfThenElse.class, "if ( a && b || c ) { }" );

		// unary numerical conditions
		assertNode( IfThenElse.class, "if ( +22 ) { }" );
		assertNode( IfThenElse.class, "if ( -22 ) { }" );
		assertNode( IfThenElse.class, "if ( --9 ) { }" );

		// unary logical conditions
		assertNode( IfThenElse.class, "if ( !a ) { }" );
		assertNode( IfThenElse.class, "if ( b && !a ) { }" );

		// nested IFs
		assertNode( IfThenElse.class, "if ( true ) { if ( false ) { } }" );
		assertNode( IfThenElse.class, "if ( true ) { } else if ( true ) { if ( false ) { } }" );

		// else variant
		assertNode( IfThenElse.class, "if ( true ) { } else { }" );
		assertNode( IfThenElse.class, "if ( true ) { \"\" c: boolean } else { }" );
		assertNode( IfThenElse.class, "if ( true ) { } else { \"\" c: boolean }" );
		assertNode( IfThenElse.class, "if ( true ) { \"\" c: boolean } else { \"\" c: boolean }" );

		// else-if variant
		assertNode( IfThenElse.class, "if ( true ) { } else if ( false ) { }" );
		assertNode( IfThenElse.class, "if ( true ) { \"\" c: boolean } else if ( false ) { }" );
		assertNode( IfThenElse.class, "if ( true ) { } else if ( false ) { \"\" c: boolean }" );
		assertNode( IfThenElse.class, "if ( true ) { \"\" c: boolean } else if ( false ) { \"\" c : boolean }" );

		// multiple else-if variant
		assertNode(
			IfThenElse.class, "if ( true ) { } else if ( false ) { } else if ( true && false ) { } else { }"
		);
	}

	/**
	 * Tests form declarations.
	 */
	@Test
	public void testFormDeclarations() {
		assertNode(
			FormDeclaration.class,
			"form ThisForm {" +
			"\t\"What?\" answer : boolean" +
			"}"
		);
	}

	/**
	 * Tests question declarations.
	 */
	@Test
	public void testQuestionDeclarations() {
		assertNode( QuestionDeclaration.class, "\"What?\" answer: boolean" );
		assertNode( QuestionDeclaration.class, "\"What?\" answer = (a && !b)" );
	}

	/**
	 * Tests assignments.
	 */
	@Test
	public void testAssignments() {
		assertNode( Assignment.class, "var = true" );
		assertNode( Assignment.class, "var = 1 + 45" );
		assertNode( Assignment.class, "var = 102 * 45 + .5e+3" );
	}
}

