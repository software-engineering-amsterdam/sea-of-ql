package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Number;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.eval.Context;

/**
 * Represents Type visitor.
 */
public interface ITypeVisitor<T> {
	/**
	 * Visit a boolean type.
	 *
	 * @param node
	 * @param context
	 */
	T visit( Bool node, Context context );

	/**
	 * Visit an integer type.
	 *
	 * @param node
	 * @param context
	 */
	T visit( Int node, Context context );

	/**
	 * Visit a string type.
	 *
	 * @param node
	 * @param context
	 */
	T visit( Str node, Context context );

	/**
	 * Visit a money type.
	 *
	 * @param node
	 * @param context
	 */
	T visit( Money node, Context context );

	/**
	 * Visit a number type.
	 *
	 * @param node
	 * @param context
	 */
	T visit( Number node, Context context );
}
