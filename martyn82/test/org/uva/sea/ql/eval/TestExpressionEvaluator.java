package org.uva.sea.ql.eval;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.eval.value.Value;

/**
 * Test expression evaluator.
 */
public class TestExpressionEvaluator {
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

	/**
	 * Creates an Add expression.
	 *
	 * @param left
	 * @param right
	 *
	 * @return The expression.
	 */
	private Add createAdd( Expression left, Expression right ) {
		return new Add( left, right );
	}

	@Test
	public void testAdd() {
		assertEquals( 5, eval( createAdd( new Int( 2 ), new Int( 3 ) ) ).getValue() );
		assertEquals( 14,  eval( createAdd( new Int( 4 ), createAdd( new Int( 3 ), new Int( 7 ) ) ) ).getValue() );
		assertEquals( 1.2, eval( createAdd( new Money( 1d ), new Money( .2 ) ) ).getValue() );
	}

	@Test
	public void testNot() {
		assertEquals( true, eval( new Not( new Bool( false ) ) ).getValue() );
		assertEquals( false, eval( new Not( new Bool( true ) ) ).getValue() );
	}
}
