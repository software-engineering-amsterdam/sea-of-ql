package org.uva.sea.ql.visitor;

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

/**
 * Expression visitor.
 */
public interface IExpressionVisitor<T> {

	// Arithmetic expressions

	/**
	 * Visit addition expression.
	 *
	 * @param node
	 */
	T visit( Add node );

	/**
	 * Visit subtraction expression.
	 *
	 * @param node
	 */
	T visit( Sub node );

	/**
	 * Visit division expression.
	 *
	 * @param node
	 */
	T visit( Div node );

	/**
	 * Visit multiplication expression.
	 *
	 * @param node
	 */
	T visit( Mul node );

	// Binary Logical expressions

	/**
	 * Visit logical and expression.
	 *
	 * @param node
	 */
	T visit( And node );

	/**
	 * Visit logical or expression.
	 *
	 * @param node
	 */
	T visit( Or node );

	// Comparison expressions

	/**
	 * Visit equals expression.
	 *
	 * @param node
	 */
	T visit( Eq node );

	/**
	 * Visit greater-than-equals expression.
	 *
	 * @param node
	 */
	T visit( GEq node );

	/**
	 * Visit greater-than expression.
	 *
	 * @param node
	 */
	T visit( GT node );

	/**
	 * Visit lesser-than-equals expression.
	 *
	 * @param node
	 */
	T visit( LEq node );

	/**
	 * Visit lesser-than expression.
	 *
	 * @param node
	 */
	T visit( LT node );

	/**
	 * Visit not equals expression.
	 *
	 * @param node
	 */
	T visit( NEq node );

	// Unary logical expressions

	/**
	 * Visit logical not expression.
	 *
	 * @param node
	 */
	T visit( Not node );

	// Unary numeric expressions

	/**
	 * Visit unary plus expression.
	 *
	 * @param node
	 */
	T visit( Pos node );

	/**
	 * Visit unary minus expression.
	 *
	 * @param node
	 */
	T visit( Neg node );

	// Literal expressions

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
