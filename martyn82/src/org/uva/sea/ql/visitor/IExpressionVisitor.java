package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
import org.uva.sea.ql.ast.expression.value.Literal;

/**
 * Expression visitor.
 */
public interface IExpressionVisitor {
	/**
	 * Visit arithmetic expression.
	 *
	 * @param node
	 */
	void visit( ArithmeticExpression node );

	/**
	 * Visit logical expression.
	 *
	 * @param node
	 */
	void visit( LogicalExpression node );

	/**
	 * Visit binary expression.
	 *
	 * @param node
	 */
	void visit( BinaryExpression node );

	/**
	 * Visit unary expression.
	 *
	 * @param node
	 */
	void visit( UnaryExpression node );

	/**
	 * Visit unary numeric expression.
	 *
	 * @param node
	 */
	void visit( UnaryNumericExpression node );

	/**
	 * Visit literal expression.
	 *
	 * @param node
	 */
	void visit( Literal node );

	/**
	 * Visit identifier expression.
	 *
	 * @param node
	 */
	void visit( Ident node );
}