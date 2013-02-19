package org.uva.sea.ql.typechecker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ExpressionTest;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.AddExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.DivideExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.MultiplyExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.SubtractExpression;
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

	@Override
	@Test
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

	@Override
	@Test
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

	@Override
	@Test
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

	@Override
	@Test
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

	@Override
	@Test
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

	@Override
	@Test
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

	@Override
	@Test
	public void testAndExpression() {
		assertEquals(
			BooleanType.BOOLEAN,
			this.resolve( new AndExpression( new BooleanLiteral( true ), new BooleanLiteral( false ) ) )
		);
	}

	@Override
	@Test
	public void testOrExpression() {
		assertEquals(
			BooleanType.BOOLEAN,
			this.resolve( new OrExpression( new BooleanLiteral( true ), new BooleanLiteral( false ) ) )
		);
	}

	@Override
	@Test
	public void testNotExpression() {
		assertEquals(
			BooleanType.BOOLEAN,
			this.resolve( new NotExpression( new BooleanLiteral( true ) ) )
		);
	}

	@Override
	public void testEqualExpression() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testNotEqualExpression() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testGreaterThanExpression() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testGreaterThanOrEqualExpression() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testLesserThanExpression() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testLesserThanOrEqualExpression() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testIdentifierExpression() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testBooleanLiteral() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testIntegerLiteral() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testMoneyLiteral() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testStringLiteral() {
		// TODO Auto-generated method stub

	}

}
