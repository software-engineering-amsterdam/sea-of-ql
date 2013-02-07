package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.NumberType;
import org.uva.sea.ql.ast.type.StringType;

/**
 * Represents Type visitor.
 */
public interface TypeVisitor<T> {
	/**
	 * Visit a boolean type.
	 *
	 * @param node
	 */
	T visit( BooleanType node );

	/**
	 * Visit an integer type.
	 *
	 * @param node
	 */
	T visit( IntegerType node );

	/**
	 * Visit a string type.
	 *
	 * @param node
	 */
	T visit( StringType node );

	/**
	 * Visit a money type.
	 *
	 * @param node
	 */
	T visit( MoneyType node );

	/**
	 * Visit a number type.
	 *
	 * @param node
	 */
	T visit( NumberType node );
}
