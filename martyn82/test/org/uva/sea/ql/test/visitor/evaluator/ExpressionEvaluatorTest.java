package org.uva.sea.ql.test.visitor.evaluator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Expression;
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
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.test.IExpressionTest;
import org.uva.sea.ql.visitor.evaluator.Environment;
import org.uva.sea.ql.visitor.evaluator.Evaluator;
import org.uva.sea.ql.visitor.evaluator.value.StringValue;

/**
 * Test expression evaluator.
 */
public class ExpressionEvaluatorTest implements IExpressionTest {
	/**
	 * Holds the expression evaluator.
	 */
	private final Evaluator evaluator;

	/**
	 * Holds the environment.
	 */
	private final Environment environment;

	/**
	 * Constructs a new expression evaluator test.
	 */
	public ExpressionEvaluatorTest() {
		this.environment = new Environment();
		this.evaluator = new Evaluator( this.environment );
	}

	/**
	 * Evaluates the given expression.
	 *
	 * @param expression
	 *
	 * @return The evaluated value.
	 */
	private Object eval( Expression expression ) {
		return expression.accept( this.evaluator ).getValue();
	}

	@Override
	@Test
	public void testAdd() {
		assertEquals( 5, eval( new Add( new Int( 2 ), new Int( 3 ) ) ) );
		assertEquals( 14,  eval( new Add( new Int( 4 ), new Add( new Int( 3 ), new Int( 7 ) ) ) ) );
		assertEquals( 1.2, eval( new Add( new Money( 1d ), new Money( .2 ) ) ) );
	}

	@Override
	@Test
	public void testSub() {
		assertEquals( 8, eval( new Sub( new Int( 10 ), new Int( 2 ) ) ) );
		assertEquals( .2, eval( new Sub( new Money( .5 ), new Money( .3 ) ) ) );
		assertEquals( 6d, eval( new Sub( new Money( 7.8 ), new Add( new Int( 1 ), new Money( .8 ) ) ) ) );
	}

	@Override
	@Test
	public void testMul() {
		assertEquals( 16d, eval( new Mul( new Int( 4 ), new Money( 4d ) ) ) );
		assertEquals( 25, eval( new Mul( new Int( 5 ), new Int( 5 ) ) ) );
		assertEquals( .25, eval( new Mul( new Money( .5 ), new Money( .5 ) ) ) );
	}

	@Override
	@Test
	public void testDiv() {
		assertEquals( 3, eval( new Div( new Int( 9 ), new Int( 3 ) ) ) );
		assertEquals( 1/3, eval( new Div( new Int( 1 ), new Int( 3 ) ) ) );
	}

	@Override
	@Test
	public void testAnd() {
		assertEquals( true, eval( new And( new Bool( true ), new Bool( true ) ) ) );
		assertEquals( false, eval( new And( new Bool( true ), new Bool( false ) ) ) );
	}

	@Override
	@Test
	public void testOr() {
		assertEquals( true, eval( new Or( new Bool( true ), new Bool( false ) ) ) );
		assertEquals( true, eval( new Or( new Bool( true ), new Bool( true ) ) ) );
		assertEquals( false, eval( new Or( new Bool( false ), new Bool( false ) ) ) );
	}

	@Override
	@Test
	public void testEq() {
		assertEquals( true, eval( new Eq( new Bool( true ), new Bool( true ) ) ) );
		assertEquals( true, eval( new Eq( new Str( "hello" ), new Str( "hello" ) ) ) );
		assertEquals( true, eval( new Eq( new Int( 12 ), new Int( 12 ) ) ) );
		assertEquals( true, eval( new Eq( new Money( .3333 ), new Money( .3333 ) ) ) );

		assertEquals( false, eval( new Eq( new Bool( true ), new Int( 23 ) ) ) );
		assertEquals( false, eval( new Eq( new Str( "" ), new Int( 1 ) ) ) );
		assertEquals( false, eval( new Eq( new Money( 3 ), new Int( 3 ) ) ) );
		assertEquals( false, eval( new Eq( new Bool( true ), new Bool( false ) ) ) );
	}

	@Override
	@Test
	public void testGEq() {
		assertEquals( true, eval( new GEq( new Int( 3 ), new Int( 3 ) ) ) );
		assertEquals( true, eval( new GEq( new Int( 10 ), new Int( 9 ) ) ) );
		assertEquals( true, eval( new GEq( new Money( 1.0001  ), new Int( 1 ) ) ) );

		assertEquals( false, eval( new GEq( new Int( 10 ), new Money( 10.01 ) ) ) );
	}

	@Override
	@Test
	public void testGT() {
		assertEquals( true, eval( new GT( new Int( 4 ), new Money( 3.999999999 ) ) ) );
		assertEquals( true, eval( new GT( new Int( 0 ), new Neg( new Int( 1 ) ) ) ) );

		assertEquals( false, eval( new GT( new Neg( new Int( 1 ) ), new Int( 0 ) ) ) );
	}

	@Override
	@Test
	public void testLEq() {
		assertEquals( true, eval( new LEq( new Int( 4 ), new Money( 4.999999999 ) ) ) );
		assertEquals( true, eval( new LEq( new Int( 1 ), new Int( 1 ) ) ) );

		assertEquals( false, eval( new LEq( new Int( 1 ), new Neg( new Int( 4 ) ) ) ) );
	}

	@Override
	@Test
	public void testLT() {
		assertEquals( true, eval( new LT( new Int( 4 ), new Money( 4.999999999 ) ) ) );
		assertEquals( true, eval( new LT( new Neg( new Int( 1 ) ), new Int( 1 ) ) ) );

		assertEquals( false, eval( new LT( new Int( 1 ), new Neg( new Int( 4 ) ) ) ) );
	}

	@Override
	@Test
	public void testNot() {
		assertEquals( true, eval( new Not( new Bool( false ) ) ) );
		assertEquals( false, eval( new Not( new Bool( true ) ) ) );
		assertEquals( true, eval( new Not( new Eq( new Str( "hello" ), new Str( "world" ) ) ) ) );
	}

	@Override
	@Test
	public void testNeg() {
		assertEquals( -1, eval( new Neg( new Int( 1 ) ) ) );
		assertEquals( 23, eval( new Neg( new Int( -23 ) ) ) );
	}

	@Override
	@Test
	public void testPos() {
		// Unary plus exists for symmetry with unary minus; its operation is idempotent.
		// See: http://msdn.microsoft.com/en-us/library/ewkkxkwb.aspx
		assertEquals( 1, eval( new Pos( new Int( 1 ) ) ) );
		assertEquals( -23, eval( new Pos( new Int( -23 ) ) ) );
	}

	@Override
	@Test
	public void testNEq() {
		assertEquals( true, eval( new NEq( new Bool( true ), new Str( "some string" ) ) ) );
	}

	@Override
	@Test
	public void testId() {
		this.environment.declare( new Ident( "x" ), new StringType() );
		this.environment.assign( new Ident( "x" ), new StringValue( "value of x" ) );
		assertEquals( "value of x", eval( new Ident( "x" ) ) );
	}

	@Override
	@Test
	public void testBool() {
		assertEquals( true, eval( new Bool( true ) ) );
		assertEquals( false, eval( new Bool( false ) ) );
	}

	@Override
	@Test
	public void testInt() {
		assertEquals( 0, eval( new Int( 0 ) ) );
		assertEquals( 129173182, eval( new Int( 129173182 ) ) );
		assertEquals( -12113, eval( new Int( -12113 ) ) );
	}

	@Override
	@Test
	public void testMoney() {
		assertEquals( 0d, eval( new Money( 0 ) ) );
		assertEquals( -.23211, eval( new Money( -.23211) ) );
		assertEquals( 15.321e-05, eval( new Money( 15.321e-05 ) ) );
	}

	@Override
	@Test
	public void testStr() {
		assertEquals( "", eval( new Str( "" ) ) );
		assertEquals( "string", eval( new Str( "string" ) ) );
	}
}
