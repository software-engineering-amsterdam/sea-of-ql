package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Number;
import org.uva.sea.ql.ast.type.Str;

/**
 * Represents Type visitor.
 */
public interface TypeVisitor<T> {
	/**
	 * Visit a boolean type.
	 *
	 * @param node
	 */
	T visit( Bool node );

	/**
	 * Visit an integer type.
	 *
	 * @param node
	 */
	T visit( Int node );

	/**
	 * Visit a string type.
	 *
	 * @param node
	 */
	T visit( Str node );

	/**
	 * Visit a money type.
	 *
	 * @param node
	 */
	T visit( Money node );

	/**
	 * Visit a number type.
	 *
	 * @param node
	 */
	T visit( Number node );
}
