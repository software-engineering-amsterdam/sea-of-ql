package org.uva.sea.ql.test.eval;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
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
import org.uva.sea.ql.eval.ExpressionEvaluator;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.test.IExpressionTest;

/**
 * Test expression evaluator.
 */
public class TestExpressionEvaluator implements IExpressionTest {
	/**
	 * Holds the expression evaluator.
	 */
	private final ExpressionEvaluator evaluator;

	/**
	 * Constructs a new expression evaluator test.
	 */
	public TestExpressionEvaluator() {
		this.evaluator = new ExpressionEvaluator();
	}

	/**
	 * Evaluates the given expression.
	 *
	 * @param expression
	 *
	 * @return The produced value.
	 */
	private Value eval( Expression expression ) {
		return expression.accept( evaluator );
	}

	@Override
	@Test
	public void testAdd() {
		assertEquals( 5, eval( new Add( new Int( 2 ), new Int( 3 ) ) ).getValue() );
		assertEquals( 14,  eval( new Add( new Int( 4 ), new Add( new Int( 3 ), new Int( 7 ) ) ) ).getValue() );
		assertEquals( 1.2, eval( new Add( new Money( 1d ), new Money( .2 ) ) ).getValue() );
	}

	@Override
	@Test
	public void testSub() {
		assertEquals( 8, eval( new Sub( new Int( 10 ), new Int( 2 ) ) ).getValue() );
		assertEquals( .2, eval( new Sub( new Money( .5 ), new Money( .3 ) ) ).getValue() );
		assertEquals( 6d, eval( new Sub( new Money( 7.8 ), new Add( new Int( 1 ), new Money( .8 ) ) ) ).getValue() );
	}

	@Override
	@Test
	public void testMul() {
		assertEquals( 16d, eval( new Mul( new Int( 4 ), new Money( 4d ) ) ).getValue() );
		assertEquals( 25, eval( new Mul( new Int( 5 ), new Int( 5 ) ) ).getValue() );
		assertEquals( .25, eval( new Mul( new Money( .5 ), new Money( .5 ) ) ).getValue() );
	}

	@Override
	@Test
	public void testDiv() {
		assertEquals( 3, eval( new Div( new Int( 9 ), new Int( 3 ) ) ).getValue() );
		assertEquals( 1/3, eval( new Div( new Int( 1 ), new Int( 3 ) ) ).getValue() );
		// TODO assertEquals( 0, eval( new Div( new Int( 10 ), new Int( 0 ) ) ).getValue() );
	}

	@Override
	@Test
	public void testAnd() {
		assertEquals( true, eval( new And( new Bool( true ), new Bool( true ) ) ).getValue() );
		assertEquals( false, eval( new And( new Bool( true ), new Bool( false ) ) ).getValue() );
	}

	@Override
	@Test
	public void testOr() {
		assertEquals( true, eval( new Or( new Bool( true ), new Bool( false ) ) ).getValue() );
		assertEquals( true, eval( new Or( new Bool( true ), new Bool( true ) ) ).getValue() );
		assertEquals( false, eval( new Or( new Bool( false ), new Bool( false ) ) ).getValue() );
	}

	@Override
	@Test
	public void testEq() {
		assertEquals( true, eval( new Eq( new Bool( true ), new Bool( true ) ) ).getValue() );
		assertEquals( true, eval( new Eq( new Str( "hello" ), new Str( "hello" ) ) ).getValue() );
		assertEquals( true, eval( new Eq( new Int( 12 ), new Int( 12 ) ) ).getValue() );
		assertEquals( true, eval( new Eq( new Money( .3333 ), new Money( .3333 ) ) ).getValue() );

		assertEquals( false, eval( new Eq( new Bool( true ), new Int( 23 ) ) ).getValue() );
		assertEquals( false, eval( new Eq( new Str( "" ), new Int( 1 ) ) ).getValue() );
		assertEquals( false, eval( new Eq( new Money( 3 ), new Int( 3 ) ) ).getValue() );
	}

	@Override
	@Test
	public void testGEq() {
		assertEquals( true, eval( new GEq( new Int( 3 ), new Int( 3 ) ) ).getValue() );
		assertEquals( true, eval( new GEq( new Int( 10 ), new Int( 9 ) ) ).getValue() );
		assertEquals( true, eval( new GEq( new Money( 1.0001  ), new Int( 1 ) ) ).getValue() );

		assertEquals( false, eval( new GEq( new Int( 10 ), new Money( 10.01 ) ) ).getValue() );
	}

	@Override
	@Test
	public void testGT() {
		assertEquals( true, eval( new GT( new Int( 4 ), new Money( 3.999999999 ) ) ).getValue() );
		assertEquals( true, eval( new GT( new Int( 0 ), new Neg( new Int( 1 ) ) ) ).getValue() );

		assertEquals( false, eval( new GT( new Neg( new Int( 1 ) ), new Int( 0 ) ) ).getValue() );
	}

	@Override
	@Test
	public void testLEq() {
		assertEquals( true, eval( new LEq( new Int( 4 ), new Money( 4.999999999 ) ) ).getValue() );
		assertEquals( true, eval( new LEq( new Int( 1 ), new Int( 1 ) ) ).getValue() );

		assertEquals( false, eval( new LEq( new Int( 1 ), new Neg( new Int( 4 ) ) ) ).getValue() );
	}

	@Override
	@Test
	public void testLT() {
		assertEquals( true, eval( new LT( new Int( 4 ), new Money( 4.999999999 ) ) ).getValue() );
		assertEquals( true, eval( new LT( new Neg( new Int( 1 ) ), new Int( 1 ) ) ).getValue() );

		assertEquals( false, eval( new LT( new Int( 1 ), new Neg( new Int( 4 ) ) ) ).getValue() );
	}

	@Override
	@Test
	public void testNot() {
		assertEquals( true, eval( new Not( new Bool( false ) ) ).getValue() );
		assertEquals( false, eval( new Not( new Bool( true ) ) ).getValue() );
		assertEquals( true, eval( new Not( new Eq( new Str( "hello" ), new Str( "world" ) ) ) ).getValue() );
	}

	@Override
	@Test
	public void testNeg() {
		assertEquals( -1, eval( new Neg( new Int( 1 ) ) ).getValue() );
		assertEquals( 23, eval( new Neg( new Int( -23 ) ) ).getValue() );
	}

	@Override
	@Test
	public void testPos() {
		// Unary plus is meant for symmetry, is idempotent.
		// See: http://msdn.microsoft.com/en-us/library/ewkkxkwb.aspx
		assertEquals( 1, eval( new Pos( new Int( 1 ) ) ).getValue() );
		assertEquals( -23, eval( new Pos( new Int( -23 ) ) ).getValue() );
	}

	@Override
	@Test
	public void testNEq() {
		assertEquals( true, eval( new NEq( new Bool( true ), new Str( "some string" ) ) ).getValue() );
	}

	@Override
	@Test
	public void testId() {
		// TODO Auto-generated method stub
	}

	@Override
	@Test
	public void testBool() {
		assertEquals( true, eval( new Bool( true ) ).getValue() );
		assertEquals( false, eval( new Bool( false ) ).getValue() );
	}

	@Override
	@Test
	public void testInt() {
		assertEquals( 0, eval( new Int( 0 ) ).getValue() );
		assertEquals( 129173182, eval( new Int( 129173182 ) ).getValue() );
		assertEquals( -12113, eval( new Int( -12113 ) ).getValue() );
	}

	@Override
	@Test
	public void testMoney() {
		assertEquals( 0d, eval( new Money( 0 ) ).getValue() );
		assertEquals( -.23211, eval( new Money( -.23211) ).getValue() );
		assertEquals( 15.321e-05, eval( new Money( 15.321e-05 ) ).getValue() );
	}

	@Override
	@Test
	public void testStr() {
		assertEquals( "", eval( new Str( "" ) ).getValue() );
		assertEquals( "string", eval( new Str( "string" ) ).getValue() );
	}
}
