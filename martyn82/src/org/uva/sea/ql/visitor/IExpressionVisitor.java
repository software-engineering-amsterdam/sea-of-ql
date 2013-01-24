package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.ComparisonExpression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.eval.Environment;

/**
 * Expression visitor.
 */
public interface IExpressionVisitor<T> {
	/**
	 * Visit arithmetic expression.
	 *
	 * @param node
	 * @param context
	 */
	T visit( ArithmeticExpression node, Environment context );

	/**
	 * Visit logical expression.
	 *
	 * @param node
	 * @param context
	 */
	T visit( LogicalExpression node, Environment context );

	/**
	 * Visit binary expression.
	 *
	 * @param node
	 * @param context
	 */
	T visit( ComparisonExpression node, Environment context );

	/**
	 * Visit unary expression.
	 *
	 * @param node
	 * @param context
	 */
	T visit( UnaryExpression node, Environment context );

	/**
	 * Visit unary numeric expression.
	 *
	 * @param node
	 * @param context
	 */
	T visit( UnaryNumericExpression node, Environment context );

	/**
	 * Visit integer literal expression.
	 *
	 * @param node
	 * @param context
	 */
	T visit( Int node, Environment context );

	/**
	 * Visit boolean literal expression.
	 *
	 * @param node
	 * @param context
	 */
	T visit( Bool node, Environment context );

	/**
	 * Visit money literal expression.
	 *
	 * @param node
	 * @param context
	 */
	T visit( Money node, Environment context );

	/**
	 * Visit string literal expression.
	 *
	 * @param node
	 * @param context
	 */
	T visit( Str node, Environment context );

	/**
	 * Visit identifier expression.
	 *
	 * @param node
	 * @param context
	 */
	T visit( Ident node, Environment context );
}
