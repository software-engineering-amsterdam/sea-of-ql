package org.uva.sea.ql.typechecker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.uva.sea.ql.ExpressionTest;
import org.uva.sea.ql.ast.expression.Expression;
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
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.typechecker.ExpressionTypeChecker;
import org.uva.sea.ql.typechecker.TypeEnvironment;
import org.uva.sea.ql.visitor.VisitorTest;

public class ExpressionTypeCheckerTest extends VisitorTest<Boolean> implements ExpressionTest {
	private final ExpressionTypeChecker expressionVisitor;
	private final TypeEnvironment environment;

	public ExpressionTypeCheckerTest() {
		super();

		this.environment = new TypeEnvironment();
		this.expressionVisitor = new ExpressionTypeChecker( this.environment );
	}

	private Boolean typeCheck( Expression expression ) {
		this.environment.getErrors().clear();
		return expression.accept( this.expressionVisitor );
	}

	@Override
	@Test
	public void testBooleanLiteral() {
		assertTrue( typeCheck( new BooleanLiteral( true ) ) );
		assertTrue( typeCheck( new BooleanLiteral( false ) ) );
	}

	@Override
	@Test
	public void testNotExpression() {
		assertTrue( typeCheck( new NotExpression( new BooleanLiteral( true ) ) ) );
		assertTrue( typeCheck( new NotExpression( new BooleanLiteral( false ) ) ) );
		assertTrue(
			typeCheck(
				new NotExpression( new EqualExpression( new BooleanLiteral( true ), new BooleanLiteral( true ) ) )
			)
		);

		assertFalse( typeCheck( new NotExpression( new IntegerLiteral( 1 ) ) ) );
	}

	@Override
	@Test
	public void testAndExpression() {
		assertTrue( typeCheck( new AndExpression( new BooleanLiteral( true ), new BooleanLiteral( false ) ) ) );
		assertTrue( typeCheck( new AndExpression( new BooleanLiteral( false ), new BooleanLiteral( false ) ) ) );
		assertTrue( typeCheck( new AndExpression( new BooleanLiteral( true ), new BooleanLiteral( false ) ) ) );

		assertFalse( typeCheck( new AndExpression( new IntegerLiteral( 1 ), new MoneyLiteral( 1d ) ) ) );
	}

	@Override
	@Test
	public void testOrExpression() {
		assertTrue( typeCheck( new OrExpression( new BooleanLiteral( true ), new BooleanLiteral( false ) ) ) );
		assertTrue( typeCheck( new OrExpression( new BooleanLiteral( true ), new BooleanLiteral( true ) ) ) );

		assertFalse( typeCheck( new OrExpression( new IntegerLiteral( 12 ), new BooleanLiteral( false ) ) ) );
	}

	@Override
	@Test
	public void testLesserThanExpression() {
		assertTrue( typeCheck( new LesserThanExpression( new MoneyLiteral( .5 ), new MoneyLiteral( .1 ) ) ) );
		assertTrue( typeCheck( new LesserThanExpression( new IntegerLiteral( 5 ), new MoneyLiteral( .1 ) ) ) );

		assertFalse( typeCheck( new LesserThanExpression( new BooleanLiteral( false ), new MoneyLiteral( .1 ) ) ) );
	}

	@Override
	@Test
	public void testLesserThanOrEqualExpression() {
		assertTrue( typeCheck( new LesserThanOrEqualExpression( new IntegerLiteral( 23 ), new MoneyLiteral( .10 ) ) ) );
		assertTrue( typeCheck( new LesserThanOrEqualExpression( new MoneyLiteral( 23 ), new MoneyLiteral( .10 ) ) ) );
		assertTrue(
			typeCheck( new LesserThanOrEqualExpression( new IntegerLiteral( 23 ), new IntegerLiteral( 10 ) ) )
		);

		assertFalse(
			typeCheck( new LesserThanOrEqualExpression( new IntegerLiteral( 23 ), new StringLiteral( ".10" ) ) )
		);
	}

	@Override
	@Test
	public void testGreaterThanOrEqualExpression() {
		assertTrue(
			typeCheck( new GreaterThanOrEqualExpression( new IntegerLiteral( 1 ), new IntegerLiteral( -211 ) ) )
		);
		assertTrue( typeCheck( new GreaterThanOrEqualExpression( new IntegerLiteral( 12 ), new MoneyLiteral( .3 ) ) ) );
	}

	@Override
	@Test
	public void testEqualExpression() {
		assertTrue(
			typeCheck(
				new EqualExpression( new BooleanLiteral( true ), new NotExpression( new BooleanLiteral( false ) ) )
			)
		);
		assertTrue( typeCheck( new EqualExpression( new BooleanLiteral( true ), new BooleanLiteral( false ) ) ) );

		assertFalse( typeCheck( new EqualExpression( new StringLiteral( "true" ), new BooleanLiteral( false ) ) ) );
	}

	@Override
	@Test
	public void testIntegerLiteral() {
		assertTrue( typeCheck( new IntegerLiteral( 12 ) ) );
		assertTrue( typeCheck( new IntegerLiteral( 0 ) ) );
		assertTrue( typeCheck( new NegativeExpression( new IntegerLiteral( 3 ) ) ) );
		assertTrue( typeCheck( new PositiveExpression( new IntegerLiteral( 2 ) ) ) );

		assertTrue( typeCheck( new AddExpression( new IntegerLiteral( 12 ), new IntegerLiteral( 1 ) ) ) );
		assertTrue( typeCheck( new DivideExpression( new IntegerLiteral( 1 ), new IntegerLiteral( 12 ) ) ) );
		assertTrue(
			typeCheck(
				new AddExpression(
					new MultiplyExpression( new IntegerLiteral( 9 ), new IntegerLiteral( 7 ) ), new IntegerLiteral( 1 )
				)
			)
		);
		assertTrue(
			typeCheck(
				new SubtractExpression( new IntegerLiteral( 10 ), new NegativeExpression( new IntegerLiteral( 2 ) ) )
			)
		);
	}

	@Override
	@Test
	public void testMoneyLiteral() {
		assertTrue( typeCheck( new MoneyLiteral( .1 ) ) );
		assertTrue( typeCheck( new MoneyLiteral( 13141.0 ) ) );
		assertTrue( typeCheck( new MoneyLiteral( .1e+1 ) ) );

		assertTrue( typeCheck( new AddExpression( new IntegerLiteral( 12 ), new MoneyLiteral( .1 ) ) ) );
		assertTrue( typeCheck( new SubtractExpression( new IntegerLiteral( 7 ), new MoneyLiteral( .0001 ) ) ) );
		assertTrue( typeCheck( new AddExpression( new MoneyLiteral( .889e+121 ), new IntegerLiteral( 7 ) ) ) );
		assertTrue(
			typeCheck(
				new AddExpression(
					new MultiplyExpression( new MoneyLiteral( .5 ), new MoneyLiteral( .25 ) ), new MoneyLiteral( .125 )
				)
			)
		);
	}

	@Override
	@Test
	public void testStringLiteral() {
		assertTrue( typeCheck( new StringLiteral( "" ) ) );
		assertTrue( typeCheck( new StringLiteral( "yes" ) )  );
		assertTrue( typeCheck( new StringLiteral( "this is a string" ) ) );
	}

	@Override
	@Test
	public void testNotEqualExpression() {
		assertTrue(
			typeCheck(
				new NotEqualExpression( new BooleanLiteral( true ), new NotExpression( new BooleanLiteral( false ) ) )
			)
		);
		assertTrue( typeCheck( new NotEqualExpression( new StringLiteral( "hello" ), new StringLiteral( "world" ) ) ) );
		assertTrue( typeCheck( new NotEqualExpression( new BooleanLiteral( false ), new BooleanLiteral( true ) ) ) );

		assertFalse( typeCheck( new NotEqualExpression( new IntegerLiteral( 12 ), new BooleanLiteral( true ) ) ) );
		assertFalse( typeCheck( new NotEqualExpression( new StringLiteral( "" ), new BooleanLiteral( true ) ) ) );
	}

	@Override
	@Test
	public void testAddExpression() {
		assertTrue( typeCheck( new AddExpression( new IntegerLiteral( 1 ), new IntegerLiteral( 3 ) ) ) );
		assertTrue( typeCheck( new AddExpression( new MoneyLiteral( .4 ), new IntegerLiteral( 5 ) ) ) );
		assertTrue( typeCheck( new AddExpression( new MoneyLiteral( .2 ), new MoneyLiteral( 131d ) ) ) );

		assertFalse( typeCheck( new AddExpression( new BooleanLiteral( false ), new StringLiteral( "" ) ) ) );
		assertFalse( typeCheck( new AddExpression( new IntegerLiteral( 1 ), new StringLiteral( "" ) ) ) );
	}

	@Override
	@Test
	public void testSubtractExpression() {
		assertTrue( typeCheck( new SubtractExpression( new IntegerLiteral( 553 ), new IntegerLiteral( 0 ) ) ) );
		assertTrue(
			typeCheck( new SubtractExpression( new MoneyLiteral( .1114e-43 ), new IntegerLiteral( 121112 ) ) )
		);

		assertFalse( typeCheck( new SubtractExpression( new MoneyLiteral( .1 ), new BooleanLiteral( true ) ) ) );
	}

	@Override
	@Test
	public void testMultiplyExpression() {
		assertTrue( typeCheck( new MultiplyExpression( new IntegerLiteral( 4 ), new IntegerLiteral( 131 ) ) ) );
		assertTrue( typeCheck( new MultiplyExpression( new MoneyLiteral( 131241.121 ), new MoneyLiteral( .3 ) ) ) );
		assertTrue( typeCheck( new MultiplyExpression( new IntegerLiteral( 554 ), new MoneyLiteral( .2 ) ) ) );

		assertFalse( typeCheck( new MultiplyExpression( new StringLiteral( "" ), new IntegerLiteral( -121 ) ) ) );
	}

	@Override
	@Test
	public void testDivideExpression() {
		assertTrue( typeCheck( new DivideExpression( new IntegerLiteral( 12 ), new IntegerLiteral( 0 ) ) ) );
		assertTrue( typeCheck( new DivideExpression( new IntegerLiteral( 41 ), new MoneyLiteral( .3 ) ) ) );
		assertTrue( typeCheck( new DivideExpression( new MoneyLiteral( 331 ), new MoneyLiteral( 1 ) ) ) );

		assertFalse( typeCheck( new DivideExpression( new IntegerLiteral( 332 ), new StringLiteral( "hoi" ) ) ) );
	}

	@Override
	@Test
	public void testNegativeExpression() {
		assertTrue( typeCheck( new NegativeExpression( new IntegerLiteral( 5 ) ) ) );
		assertTrue( typeCheck( new NegativeExpression( new MoneyLiteral( 489 ) ) ) );

		assertFalse( typeCheck( new NegativeExpression( new BooleanLiteral( true ) ) ) );
	}

	@Override
	@Test
	public void testPositiveExpression() {
		assertTrue( typeCheck( new PositiveExpression( new IntegerLiteral( -553321 ) ) ) );
		assertTrue( typeCheck( new PositiveExpression( new MoneyLiteral( .6653e+142 ) ) ) );

		assertFalse( typeCheck( new PositiveExpression( new StringLiteral( "2" ) ) ) );
	}

	@Override
	@Test
	public void testGreaterThanExpression() {
		assertTrue( typeCheck( new GreaterThanExpression( new IntegerLiteral( 42 ), new IntegerLiteral( 3241 ) ) ) );
		assertTrue( typeCheck( new GreaterThanExpression( new MoneyLiteral( 342 ), new IntegerLiteral( 1 ) ) ) );

		assertFalse(
			typeCheck(
				new GreaterThanExpression(
					new AndExpression(
						new BooleanLiteral( true ), new BooleanLiteral( false )
					),
					new IntegerLiteral( 1 )
				)
			)
		);
	}

	@Override
	@Test
	public void testIdentifierExpression() {
		IdentifierExpression identBVar = new IdentifierExpression( "bVar" );
		IdentifierExpression identIVar = new IdentifierExpression( "iVar" );

		this.environment.declare( identBVar, BooleanType.BOOLEAN );
		this.environment.declare( identIVar, IntegerType.INTEGER );

		assertTrue( typeCheck( identBVar ) );
		assertTrue( typeCheck( identIVar ) );

		assertTrue( typeCheck( new EqualExpression( identBVar, new BooleanLiteral( false ) ) ) );
		assertTrue( typeCheck( new AddExpression( identIVar, new MoneyLiteral( 131.2 ) ) ) );

		assertFalse( typeCheck( new EqualExpression( identBVar, identIVar ) ) );
		assertFalse( typeCheck( new AddExpression( identIVar, identBVar ) ) );
	}
}
