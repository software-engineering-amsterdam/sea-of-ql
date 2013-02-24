package org.uva.sea.ql.evaluate.render;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ExpressionTest;
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
import org.uva.sea.ql.evaluate.render.BindingEnvironment;
import org.uva.sea.ql.value.StringValue;

public class ExpressionEvaluatorTest extends EvaluatorTest implements ExpressionTest {
	public ExpressionEvaluatorTest() {
		super( new BindingEnvironment() );
	}

	@Test
	@Override
	public void testAddExpression() {
		assertEquals( 5, eval( new AddExpression( new IntegerLiteral( 2 ), new IntegerLiteral( 3 ) ) ) );
		assertEquals(
			14,
			eval(
				new AddExpression(
					new IntegerLiteral( 4 ),
					new AddExpression( new IntegerLiteral( 3 ), new IntegerLiteral( 7 ) )
				)
			)
		);
		assertEquals( 1.2, eval( new AddExpression( new MoneyLiteral( 1d ), new MoneyLiteral( .2 ) ) ) );
	}

	@Test
	@Override
	public void testSubtractExpression() {
		assertEquals( 8, eval( new SubtractExpression( new IntegerLiteral( 10 ), new IntegerLiteral( 2 ) ) ) );
		assertEquals( .2, eval( new SubtractExpression( new MoneyLiteral( .5 ), new MoneyLiteral( .3 ) ) ) );
		assertEquals(
			6d,
			eval(
				new SubtractExpression(
					new MoneyLiteral( 7.8 ), new AddExpression( new IntegerLiteral( 1 ), new MoneyLiteral( .8 ) )
				)
			)
		);
	}

	@Test
	@Override
	public void testMultiplyExpression() {
		assertEquals( 16d, eval( new MultiplyExpression( new IntegerLiteral( 4 ), new MoneyLiteral( 4d ) ) ) );
		assertEquals( 25, eval( new MultiplyExpression( new IntegerLiteral( 5 ), new IntegerLiteral( 5 ) ) ) );
		assertEquals( .25, eval( new MultiplyExpression( new MoneyLiteral( .5 ), new MoneyLiteral( .5 ) ) ) );
	}

	@Test
	@Override
	public void testDivideExpression() {
		assertEquals( 3, eval( new DivideExpression( new IntegerLiteral( 9 ), new IntegerLiteral( 3 ) ) ) );
		assertEquals( 1/3, eval( new DivideExpression( new IntegerLiteral( 1 ), new IntegerLiteral( 3 ) ) ) );
	}

	@Test
	@Override
	public void testAndExpression() {
		assertEquals( true, eval( new AndExpression( new BooleanLiteral( true ), new BooleanLiteral( true ) ) ) );
		assertEquals( false, eval( new AndExpression( new BooleanLiteral( true ), new BooleanLiteral( false ) ) ) );
	}

	@Test
	@Override
	public void testOrExpression() {
		assertEquals( true, eval( new OrExpression( new BooleanLiteral( true ), new BooleanLiteral( false ) ) ) );
		assertEquals( true, eval( new OrExpression( new BooleanLiteral( true ), new BooleanLiteral( true ) ) ) );
		assertEquals( false, eval( new OrExpression( new BooleanLiteral( false ), new BooleanLiteral( false ) ) ) );
	}

	@Test
	@Override
	public void testEqualExpression() {
		assertEquals( true, eval( new EqualExpression( new BooleanLiteral( true ), new BooleanLiteral( true ) ) ) );
		assertEquals( true, eval( new EqualExpression( new StringLiteral( "hello" ), new StringLiteral( "hello" ) ) ) );
		assertEquals( true, eval( new EqualExpression( new IntegerLiteral( 12 ), new IntegerLiteral( 12 ) ) ) );
		assertEquals( true, eval( new EqualExpression( new MoneyLiteral( .3333 ), new MoneyLiteral( .3333 ) ) ) );

		assertEquals( false, eval( new EqualExpression( new BooleanLiteral( true ), new IntegerLiteral( 23 ) ) ) );
		assertEquals( false, eval( new EqualExpression( new StringLiteral( "" ), new IntegerLiteral( 1 ) ) ) );
		assertEquals( false, eval( new EqualExpression( new MoneyLiteral( 3 ), new IntegerLiteral( 3 ) ) ) );
		assertEquals( false, eval( new EqualExpression( new BooleanLiteral( true ), new BooleanLiteral( false ) ) ) );
	}

	@Test
	@Override
	public void testGreaterThanOrEqualExpression() {
		assertEquals(
			true,
			eval( new GreaterThanOrEqualExpression( new IntegerLiteral( 3 ), new IntegerLiteral( 3 ) ) )
		);
		assertEquals(
			true,
			eval( new GreaterThanOrEqualExpression( new IntegerLiteral( 10 ), new IntegerLiteral( 9 ) ) )
		);
		assertEquals(
			true,
			eval( new GreaterThanOrEqualExpression( new MoneyLiteral( 1.0001  ), new IntegerLiteral( 1 ) ) )
		);

		assertEquals(
			false,
			eval( new GreaterThanOrEqualExpression( new IntegerLiteral( 10 ), new MoneyLiteral( 10.01 ) ) )
		);
	}

	@Test
	@Override
	public void testGreaterThanExpression() {
		assertEquals(
			true,
			eval( new GreaterThanExpression( new IntegerLiteral( 4 ), new MoneyLiteral( 3.999999999 ) ) )
		);
		assertEquals(
			true,
			eval(
				new GreaterThanExpression( new IntegerLiteral( 0 ), new NegativeExpression( new IntegerLiteral( 1 ) ) )
			)
		);

		assertEquals(
			false,
			eval(
				new GreaterThanExpression( new NegativeExpression( new IntegerLiteral( 1 ) ), new IntegerLiteral( 0 ) )
			)
		);
	}

	@Test
	@Override
	public void testLesserThanOrEqualExpression() {
		assertEquals(
			true,
			eval( new LesserThanOrEqualExpression( new IntegerLiteral( 4 ), new MoneyLiteral( 4.999999999 ) ) )
		);
		assertEquals(
			true,
			eval( new LesserThanOrEqualExpression( new IntegerLiteral( 1 ), new IntegerLiteral( 1 ) ) )
		);

		assertEquals(
			false,
			eval(
				new LesserThanOrEqualExpression(
					new IntegerLiteral( 1 ), new NegativeExpression( new IntegerLiteral( 4 ) )
				)
			)
		);
	}

	@Test
	@Override
	public void testLesserThanExpression() {
		assertEquals(
			true,
			eval( new LesserThanExpression( new IntegerLiteral( 4 ), new MoneyLiteral( 4.999999999 ) ) )
		);
		assertEquals(
			true,
			eval(
				new LesserThanExpression( new NegativeExpression( new IntegerLiteral( 1 ) ), new IntegerLiteral( 1 ) )
			)
		);

		assertEquals(
			false,
			eval(
				new LesserThanExpression( new IntegerLiteral( 1 ), new NegativeExpression( new IntegerLiteral( 4 ) ) )
			)
		);
	}

	@Test
	@Override
	public void testNotExpression() {
		assertEquals( true, eval( new NotExpression( new BooleanLiteral( false ) ) ) );
		assertEquals( false, eval( new NotExpression( new BooleanLiteral( true ) ) ) );
		assertEquals(
			true,
			eval(
				new NotExpression( new EqualExpression( new StringLiteral( "hello" ), new StringLiteral( "world" ) ) )
			)
		);
	}

	@Test
	@Override
	public void testNegativeExpression() {
		assertEquals( -1, eval( new NegativeExpression( new IntegerLiteral( 1 ) ) ) );
		assertEquals( 23, eval( new NegativeExpression( new IntegerLiteral( -23 ) ) ) );
	}

	@Test
	@Override
	public void testPositiveExpression() {
		// Unary plus exists for symmetry with unary minus; its operation is idempotent.
		// See: http://msdn.microsoft.com/en-us/library/ewkkxkwb.aspx
		assertEquals( 1, eval( new PositiveExpression( new IntegerLiteral( 1 ) ) ) );
		assertEquals( -23, eval( new PositiveExpression( new IntegerLiteral( -23 ) ) ) );
	}

	@Test
	@Override
	public void testNotEqualExpression() {
		assertEquals(
			true,
			eval( new NotEqualExpression( new BooleanLiteral( true ), new StringLiteral( "some string" ) ) )
		);
	}

	@Test
	@Override
	public void testIdentifierExpression() {
		this.environment.declare( new IdentifierExpression( "x" ), new StringValue( "value of x" ) );
		assertEquals( "value of x", eval( new IdentifierExpression( "x" ) ) );
	}

	@Test
	@Override
	public void testBooleanLiteral() {
		assertEquals( true, eval( new BooleanLiteral( true ) ) );
		assertEquals( false, eval( new BooleanLiteral( false ) ) );
	}

	@Test
	@Override
	public void testIntegerLiteral() {
		assertEquals( 0, eval( new IntegerLiteral( 0 ) ) );
		assertEquals( 129173182, eval( new IntegerLiteral( 129173182 ) ) );
		assertEquals( -12113, eval( new IntegerLiteral( -12113 ) ) );
	}

	@Test
	@Override
	public void testMoneyLiteral() {
		assertEquals( 0d, eval( new MoneyLiteral( 0 ) ) );
		assertEquals( -.23211, eval( new MoneyLiteral( -.23211) ) );
		assertEquals( 15.321e-05, eval( new MoneyLiteral( 15.321e-05 ) ) );
	}

	@Test
	@Override
	public void testStringLiteral() {
		assertEquals( "", eval( new StringLiteral( "" ) ) );
		assertEquals( "string", eval( new StringLiteral( "string" ) ) );
	}
}
