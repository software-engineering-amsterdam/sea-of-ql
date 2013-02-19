package org.uva.sea.ql.printer;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

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
import org.uva.sea.ql.printer.ExpressionToString;

public class ExpressionToStringTest implements ExpressionTest {
	private final ExpressionToString printer;

	public ExpressionToStringTest() {
		Locale.setDefault( Locale.ENGLISH ); // needed for money-to-string comparison
		this.printer = new ExpressionToString();
	}

	private String stringify( Expression expression ) {
		return expression.accept( this.printer );
	}

	@Override
	@Test
	public void testAddExpression() {
		Expression expression;

		expression = new AddExpression( new IntegerLiteral( 12 ), new IntegerLiteral( 23 ) );
		assertEquals( "(12 + 23)", this.stringify( expression ) );

		expression = new AddExpression(
			new IntegerLiteral( 43 ), new AddExpression( new MoneyLiteral( .555 ), new IntegerLiteral( 4 ) )
		);
		assertEquals( "(43 + (0.56 + 4))", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testSubtractExpression() {
		Expression expression = new SubtractExpression(
			new IntegerLiteral( 7 ), new NegativeExpression( new IntegerLiteral( 54 ) )
		);
		assertEquals( "(7 - (- 54))", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testMultiplyExpression() {
		Expression expression = new MultiplyExpression(
			new IntegerLiteral( 55 ), new MoneyLiteral( .5 )
		);
		assertEquals( "(55 * 0.50)", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testDivideExpression() {
		Expression expression = new DivideExpression(
			new IntegerLiteral( 99 ), new MoneyLiteral( .121 )
		);
		assertEquals( "(99 / 0.12)", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testNegativeExpression() {
		Expression expression = new NegativeExpression(
			new MoneyLiteral( 128.33 )
		);
		assertEquals( "(- 128.33)", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testPositiveExpression() {
		Expression expression = new PositiveExpression(
			new AddExpression(
				new IntegerLiteral( 611 ), new IntegerLiteral( 0 )
			)
		);
		assertEquals( "(+ (611 + 0))", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testAndExpression() {
		Expression expression = new AndExpression(
			new BooleanLiteral( true ), new BooleanLiteral( false )
		);
		assertEquals( "(true && false)", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testOrExpression() {
		Expression expression = new OrExpression(
			new BooleanLiteral( true ), new BooleanLiteral( false )
		);
		assertEquals( "(true || false)", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testNotExpression() {
		Expression expression = new NotExpression( new BooleanLiteral( true ) );
		assertEquals( "(! true)", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testEqualExpression() {
		Expression expression = new EqualExpression(
			new IntegerLiteral( 4 ), new BooleanLiteral( false )
		);
		assertEquals( "(4 == false)", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testNotEqualExpression() {
		Expression expression = new NotEqualExpression(
			new BooleanLiteral( false ), new StringLiteral( "hello" )
		);
		assertEquals( "(false != (hello))", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testGreaterThanExpression() {
		Expression expression = new GreaterThanExpression(
			new IntegerLiteral( 0 ), new IntegerLiteral( 12 )
		);
		assertEquals( "(0 > 12)", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testGreaterThanOrEqualExpression() {
		Expression expression = new GreaterThanOrEqualExpression(
			new IntegerLiteral( 33 ), new MoneyLiteral( 41211.01 )
		);
		assertEquals( "(33 >= 41211.01)", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testLesserThanExpression() {
		Expression expression = new LesserThanExpression(
			new MoneyLiteral( .001 ), new IntegerLiteral( 9999999 )
		);
		assertEquals( "(0.00 < 9999999)", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testLesserThanOrEqualExpression() {
		Expression expression = new LesserThanOrEqualExpression(
			new IntegerLiteral( 0 ), new MoneyLiteral( .0 )
		);
		assertEquals( "(0 <= 0.00)", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testIdentifierExpression() {
		Expression expression = new IdentifierExpression( "varX" );
		assertEquals( "varX", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testBooleanLiteral() {
		Expression expression = new BooleanLiteral( true );
		assertEquals( "true", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testIntegerLiteral() {
		Expression expression = new IntegerLiteral( 12112 );
		assertEquals( "12112", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testMoneyLiteral() {
		Expression expression = new MoneyLiteral( .544 );
		assertEquals( "0.54", this.stringify( expression ) );

		expression = new MoneyLiteral( .545 );
		assertEquals( "0.55", this.stringify( expression ) );
	}

	@Override
	@Test
	public void testStringLiteral() {
		Expression expression = new StringLiteral( "hello world" );
		assertEquals( "(hello world)", this.stringify( expression ) );
	}

}
