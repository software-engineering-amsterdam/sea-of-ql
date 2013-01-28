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

/**
 * Expression visitor.
 */
public interface IExpressionVisitor<T> {
	/**
	 * Visit arithmetic expression.
	 *
	 * @param node
	 */
	T visit( ArithmeticExpression node );

	/**
	 * Visit logical expression.
	 *
	 * @param node
	 */
	T visit( LogicalExpression node );

	/**
	 * Visit binary expression.
	 *
	 * @param node
	 */
	T visit( ComparisonExpression node );

	/**
	 * Visit unary expression.
	 *
	 * @param node
	 */
	T visit( UnaryExpression node );

	/**
	 * Visit unary numeric expression.
	 *
	 * @param node
	 */
	T visit( UnaryNumericExpression node );

	/**
	 * Visit integer literal expression.
	 *
	 * @param node
	 */
	T visit( Int node );

	/**
	 * Visit boolean literal expression.
	 *
	 * @param node
	 */
	T visit( Bool node );

	/**
	 * Visit money literal expression.
	 *
	 * @param node
	 */
	T visit( Money node );

	/**
	 * Visit string literal expression.
	 *
	 * @param node
	 */
	T visit( Str node );

	/**
	 * Visit identifier expression.
	 *
	 * @param node
	 */
	T visit( Ident node );
}
