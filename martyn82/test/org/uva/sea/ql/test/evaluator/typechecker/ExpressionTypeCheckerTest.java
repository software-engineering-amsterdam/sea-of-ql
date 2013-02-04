package org.uva.sea.ql.test.evaluator.typechecker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
import org.uva.sea.ql.evaluator.Environment;
import org.uva.sea.ql.evaluator.typechecker.ExpressionChecker;
import org.uva.sea.ql.test.IExpressionTest;
import org.uva.sea.ql.test.visitor.VisitorTest;

/**
 * Expression TypeChecker test.
 */
public class ExpressionTypeCheckerTest extends VisitorTest<Boolean> implements IExpressionTest {
	/**
	 * Holds the expression checker.
	 */
	private final ExpressionChecker expressionVisitor;

	/**
	 * Holds the environment.
	 */
	private final Environment environment;

	/**
	 * Constructs a new TypeChecker test.
	 */
	public ExpressionTypeCheckerTest() {
		super();

		this.environment = new Environment();
		this.expressionVisitor = new ExpressionChecker( this.environment );
	}

	/**
	 * Typechecks the given expression.
	 *
	 * @param expression
	 *
	 * @return True if typecheck OK, false otherwise.
	 */
	private Boolean typeCheck( Expression expression ) {
		this.environment.getErrors().clear();
		return expression.accept( this.expressionVisitor );
	}

	@Override
	@Test
	public void testBool() {
		assertTrue( typeCheck( new Bool( true ) ) );
		assertTrue( typeCheck( new Bool( false ) ) );
	}

	@Override
	@Test
	public void testNot() {
		assertTrue( typeCheck( new Not( new Bool( true ) ) ) );
		assertTrue( typeCheck( new Not( new Bool( false ) ) ) );
		assertTrue( typeCheck( new Not( new Eq( new Bool( true ), new Bool( true ) ) ) ) );

		assertFalse( typeCheck( new Not( new Int( 1 ) ) ) );
	}

	@Override
	@Test
	public void testAnd() {
		assertTrue( typeCheck( new And( new Bool( true ), new Bool( false ) ) ) );
		assertTrue( typeCheck( new And( new Bool( false ), new Bool( false ) ) ) );
		assertTrue( typeCheck( new And( new Bool( true ), new Bool( false ) ) ) );

		assertFalse( typeCheck( new And( new Int( 1 ), new Money( 1d ) ) ) );
	}

	@Override
	@Test
	public void testOr() {
		assertTrue( typeCheck( new Or( new Bool( true ), new Bool( false ) ) ) );
		assertTrue( typeCheck( new Or( new Bool( true ), new Bool( true ) ) ) );

		assertFalse( typeCheck( new Or( new Int( 12 ), new Bool( false ) ) ) );
	}

	@Override
	@Test
	public void testLT() {
		assertTrue( typeCheck( new LT( new Money( .5 ), new Money( .1 ) ) ) );
		assertTrue( typeCheck( new LT( new Int( 5 ), new Money( .1 ) ) ) );

		assertFalse( typeCheck( new LT( new Bool( false ), new Money( .1 ) ) ) );
	}

	@Override
	@Test
	public void testLEq() {
		assertTrue( typeCheck( new LEq( new Int( 23 ), new Money( .10 ) ) ) );
		assertTrue( typeCheck( new LEq( new Money( 23 ), new Money( .10 ) ) ) );
		assertTrue( typeCheck( new LEq( new Int( 23 ), new Int( 10 ) ) ) );

		assertFalse( typeCheck( new LEq( new Int( 23 ), new Str( ".10" ) ) ) );
	}

	@Override
	@Test
	public void testGEq() {
		assertTrue( typeCheck( new GEq( new Int( 1 ), new Int( -211 ) ) ) );
		assertTrue( typeCheck( new GEq( new Int( 12 ), new Money( .3 ) ) ) );
	}

	@Override
	@Test
	public void testEq() {
		assertTrue( typeCheck( new Eq( new Bool( true ), new Not( new Bool( false ) ) ) ) );
		assertTrue( typeCheck( new Eq( new Bool( true ), new Bool( false ) ) ) );

		assertFalse( typeCheck( new Eq( new Str( "true" ), new Bool( false ) ) ) );
	}

	@Override
	@Test
	public void testInt() {
		assertTrue( typeCheck( new Int( 12 ) ) );
		assertTrue( typeCheck( new Int( 0 ) ) );
		assertTrue( typeCheck( new Neg( new Int( 3 ) ) ) );
		assertTrue( typeCheck( new Pos( new Int( 2 ) ) ) );

		assertTrue( typeCheck( new Add( new Int( 12 ), new Int( 1 ) ) ) );
		assertTrue( typeCheck( new Div( new Int( 1 ), new Int( 12 ) ) ) );
		assertTrue( typeCheck( new Add( new Mul( new Int( 9 ), new Int( 7 ) ), new Int( 1 ) ) ) );
		assertTrue( typeCheck( new Sub( new Int( 10 ), new Neg( new Int( 2 ) ) ) ) );
	}

	@Override
	@Test
	public void testMoney() {
		assertTrue( typeCheck( new Money( .1 ) ) );
		assertTrue( typeCheck( new Money( 13141.0 ) ) );
		assertTrue( typeCheck( new Money( .1e+1 ) ) );

		assertTrue( typeCheck( new Add( new Int( 12 ), new Money( .1 ) ) ) );
		assertTrue( typeCheck( new Sub( new Int( 7 ), new Money( .0001 ) ) ) );
		assertTrue( typeCheck( new Add( new Money( .889e+121 ), new Int( 7 ) ) ) );
		assertTrue( typeCheck( new Add( new Mul( new Money( .5 ), new Money( .25 ) ), new Money( .125 ) ) ) );
	}

	@Override
	@Test
	public void testStr() {
		assertTrue( typeCheck( new Str( "" ) ) );
		assertTrue( typeCheck( new Str( "yes" ) )  );
		assertTrue( typeCheck( new Str( "this is a string" ) ) );
	}

	@Override
	@Test
	public void testNEq() {
		assertTrue( typeCheck( new NEq( new Bool( true ), new Not( new Bool( false ) ) ) ) );
		assertTrue( typeCheck( new NEq( new Str( "hello" ), new Str( "world" ) ) ) );
		assertTrue( typeCheck( new NEq( new Bool( false ), new Bool( true ) ) ) );

		assertFalse( typeCheck( new NEq( new Int( 12 ), new Bool( true ) ) ) );
		assertFalse( typeCheck( new NEq( new Str( "" ), new Bool( true ) ) ) );
	}

	@Override
	@Test
	public void testAdd() {
		assertTrue( typeCheck( new Add( new Int( 1 ), new Int( 3 ) ) ) );
		assertTrue( typeCheck( new Add( new Money( .4 ), new Int( 5 ) ) ) );
		assertTrue( typeCheck( new Add( new Money( .2 ), new Money( 131d ) ) ) );

		assertFalse( typeCheck( new Add( new Bool( false ), new Str( "" ) ) ) );
		assertFalse( typeCheck( new Add( new Int( 1 ), new Str( "" ) ) ) );
	}

	@Override
	@Test
	public void testSub() {
		assertTrue( typeCheck( new Sub( new Int( 553 ), new Int( 0 ) ) ) );
		assertTrue( typeCheck( new Sub( new Money( .1114e-43 ), new Int( 121112 ) ) ) );

		assertFalse( typeCheck( new Sub( new Money( .1 ), new Bool( true ) ) ) );
	}

	@Override
	@Test
	public void testMul() {
		assertTrue( typeCheck( new Mul( new Int( 4 ), new Int( 131 ) ) ) );
		assertTrue( typeCheck( new Mul( new Money( 131241.121 ), new Money( .3 ) ) ) );
		assertTrue( typeCheck( new Mul( new Int( 554 ), new Money( .2 ) ) ) );

		assertFalse( typeCheck( new Mul( new Str( "" ), new Int( -121 ) ) ) );
	}

	@Override
	@Test
	public void testDiv() {
		assertTrue( typeCheck( new Div( new Int( 12 ), new Int( 0 ) ) ) );
		assertTrue( typeCheck( new Div( new Int( 41 ), new Money( .3 ) ) ) );
		assertTrue( typeCheck( new Div( new Money( 331 ), new Money( 1 ) ) ) );

		assertFalse( typeCheck( new Div( new Int( 332 ), new Str( "hoi" ) ) ) );
	}

	@Override
	@Test
	public void testNeg() {
		assertTrue( typeCheck( new Neg( new Int( 5 ) ) ) );
		assertTrue( typeCheck( new Neg( new Money( 489 ) ) ) );

		assertFalse( typeCheck( new Neg( new Bool( true ) ) ) );
	}

	@Override
	@Test
	public void testPos() {
		assertTrue( typeCheck( new Pos( new Int( -553321 ) ) ) );
		assertTrue( typeCheck( new Pos( new Money( .6653e+142 ) ) ) );

		assertFalse( typeCheck( new Pos( new Str( "2" ) ) ) );
	}

	@Override
	@Test
	public void testGT() {
		assertTrue( typeCheck( new GT( new Int( 42 ), new Int( 3241 ) ) ) );
		assertTrue( typeCheck( new GT( new Money( 342 ), new Int( 1 ) ) ) );

		assertFalse( typeCheck( new GT( new And( new Bool( true ), new Bool( false ) ), new Int( 1 ) ) ) );
	}

	@Override
	@Test
	public void testId() {
		Ident identBVar = new Ident( "bVar" );
		Ident identIVar = new Ident( "iVar" );

		this.environment.declare( identBVar, new org.uva.sea.ql.ast.type.Bool() );
		this.environment.declare( identIVar, new org.uva.sea.ql.ast.type.Int() );

		assertTrue( typeCheck( identBVar ) );
		assertTrue( typeCheck( identIVar ) );

		assertTrue( typeCheck( new Eq( identBVar, new Bool( false ) ) ) );
		assertTrue( typeCheck( new Add( identIVar, new Money( 131.2 ) ) ) );

		assertFalse( typeCheck( new Eq( identBVar, identIVar ) ) );
		assertFalse( typeCheck( new Add( identIVar, identBVar ) ) );
	}
}
