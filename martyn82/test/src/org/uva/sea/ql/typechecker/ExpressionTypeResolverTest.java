package org.uva.sea.ql.typechecker;

import static org.junit.Assert.assertEquals;

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
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefinedType;

public class ExpressionTypeResolverTest implements ExpressionTest {
	private final TypeEnvironment environment;

	public ExpressionTypeResolverTest() {
		this.environment = new TypeEnvironment();
	}

	private Type resolve( Expression expression ) {
		return ExpressionTypeResolver.typeOf( expression, this.environment );
	}

	@Test
	@Override
	public void testAddExpression() {
		assertEquals(
			IntegerType.INTEGER,
			this.resolve( new AddExpression( new IntegerLiteral( 12 ), new IntegerLiteral( 0 ) ) )
		);

		assertEquals(
			MoneyType.MONEY,
			this.resolve( new AddExpression( new MoneyLiteral( .5 ), new IntegerLiteral( 0 ) ) )
		);
	}

	@Test
	@Override
	public void testSubtractExpression() {
		assertEquals(
			IntegerType.INTEGER,
			this.resolve( new SubtractExpression( new IntegerLiteral( 1 ), new IntegerLiteral( 0 ) ) )
		);

		assertEquals(
			MoneyType.MONEY,
			this.resolve( new SubtractExpression( new MoneyLiteral( 12 ), new IntegerLiteral( 44 ) ) )
		);
	}

	@Test
	@Override
	public void testMultiplyExpression() {
		assertEquals(
			IntegerType.INTEGER,
			this.resolve( new MultiplyExpression( new IntegerLiteral( 453 ), new IntegerLiteral( 37 ) ) )
		);

		assertEquals(
			MoneyType.MONEY,
			this.resolve( new MultiplyExpression( new MoneyLiteral( 23 ), new IntegerLiteral( 12 ) ) )
		);

		assertEquals(
			UndefinedType.UNDEFINED,
			this.resolve( new MultiplyExpression( new StringLiteral( "" ), new StringLiteral( "12" ) ) )
		);
	}

	@Test
	@Override
	public void testDivideExpression() {
		assertEquals(
			IntegerType.INTEGER,
			this.resolve( new DivideExpression( new IntegerLiteral( 121 ), new IntegerLiteral( 11 ) ) )
		);

		assertEquals(
			MoneyType.MONEY,
			this.resolve( new DivideExpression( new MoneyLiteral( .21 ), new IntegerLiteral( 191 ) ) )
		);
	}

	@Test
	@Override
	public void testNegativeExpression() {
		assertEquals(
			IntegerType.INTEGER,
			this.resolve( new NegativeExpression( new IntegerLiteral( 12 ) ) )
		);

		assertEquals(
			MoneyType.MONEY,
			this.resolve( new NegativeExpression( new MoneyLiteral( .11 ) ) )
		);
	}

	@Test
	@Override
	public void testPositiveExpression() {
		assertEquals(
			IntegerType.INTEGER,
			this.resolve( new PositiveExpression( new IntegerLiteral( 12 ) ) )
		);

		assertEquals(
			MoneyType.MONEY,
			this.resolve( new PositiveExpression( new MoneyLiteral( .11 ) ) )
		);
	}

	@Test
	@Override
	public void testAndExpression() {
		assertEquals(
			BooleanType.BOOLEAN,
			this.resolve( new AndExpression( new BooleanLiteral( true ), new BooleanLiteral( false ) ) )
		);
	}

	@Test
	@Override
	public void testOrExpression() {
		assertEquals(
			BooleanType.BOOLEAN,
			this.resolve( new OrExpression( new BooleanLiteral( true ), new BooleanLiteral( false ) ) )
		);
	}

	@Test
	@Override
	public void testNotExpression() {
		assertEquals(
			BooleanType.BOOLEAN,
			this.resolve( new NotExpression( new BooleanLiteral( true ) ) )
		);
	}

	@Test
	@Override
	public void testEqualExpression() {
		assertEquals(
			BooleanType.BOOLEAN,
			this.resolve( new EqualExpression( new BooleanLiteral( true ), new StringLiteral( "foo" ) ) )
		);
	}

	@Test
	@Override
	public void testNotEqualExpression() {
		assertEquals(
			BooleanType.BOOLEAN,
			this.resolve( new NotEqualExpression( new BooleanLiteral( true ), new StringLiteral( "bar" ) ) )
		);
	}

	@Test
	@Override
	public void testGreaterThanExpression() {
		assertEquals(
			BooleanType.BOOLEAN,
			this.resolve( new GreaterThanExpression( new IntegerLiteral( 12 ), new BooleanLiteral( false ) ) )
		);
	}

	@Test
	@Override
	public void testGreaterThanOrEqualExpression() {
		assertEquals(
			BooleanType.BOOLEAN,
			this.resolve( new GreaterThanOrEqualExpression( new IntegerLiteral( 111 ), new MoneyLiteral( .2 ) ) )
		);
	}

	@Test
	@Override
	public void testLesserThanExpression() {
		assertEquals(
			BooleanType.BOOLEAN,
			this.resolve( new LesserThanExpression( new BooleanLiteral( true ), new StringLiteral( "foo bar" ) ) )
		);
	}

	@Test
	@Override
	public void testLesserThanOrEqualExpression() {
		assertEquals(
			BooleanType.BOOLEAN,
			this.resolve( new LesserThanOrEqualExpression( new IntegerLiteral( 112 ), new IntegerLiteral( -21 ) ) )
		);
	}

	@Test
	@Override
	public void testIdentifierExpression() {
		assertEquals(
			UndefinedType.UNDEFINED,
			this.resolve( new IdentifierExpression( "foo" ) )
		);

		this.environment.declare( new IdentifierExpression( "bar" ), StringType.STRING );
		assertEquals(
			StringType.STRING,
			this.resolve( new IdentifierExpression( "bar" ) )
		);
	}

	@Test
	@Override
	public void testBooleanLiteral() {
		assertEquals(
			BooleanType.BOOLEAN,
			this.resolve( new BooleanLiteral( false ) )
		);

		assertEquals(
			BooleanType.BOOLEAN,
			this.resolve( new BooleanLiteral( true ) )
		);
	}

	@Test
	@Override
	public void testIntegerLiteral() {
		assertEquals(
			IntegerType.INTEGER,
			this.resolve( new IntegerLiteral( 0 ) )
		);

		assertEquals(
			IntegerType.INTEGER,
			this.resolve( new IntegerLiteral( 1821 ) )
		);

		assertEquals(
			IntegerType.INTEGER,
			this.resolve( new IntegerLiteral( -992 ) )
		);
	}

	@Test
	@Override
	public void testMoneyLiteral() {
		assertEquals(
			MoneyType.MONEY,
			this.resolve( new MoneyLiteral( .0 ) )
		);

		assertEquals(
			MoneyType.MONEY,
			this.resolve( new MoneyLiteral( 18.21 ) )
		);

		assertEquals(
			MoneyType.MONEY,
			this.resolve( new MoneyLiteral( -99.2 ) )
		);
	}

	@Test
	@Override
	public void testStringLiteral() {
		assertEquals(
			StringType.STRING,
			this.resolve( new StringLiteral( "" ) )
		);

		assertEquals(
			StringType.STRING,
			this.resolve( new StringLiteral( "foo bar" ) )
		);
	}
}
