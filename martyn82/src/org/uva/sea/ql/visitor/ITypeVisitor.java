package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.evaluate.Context;
import org.uva.sea.ql.evaluate.Value;

/**
 * Type node visitor.
 */
public interface ITypeVisitor {
	/**
	 * Visit a boolean type node.
	 *
	 * @param node
	 * @param context
	 *
	 * @return The value.
	 */
	Value visit( Bool node, Context context );

	/**
	 * Visit an integer type node.
	 *
	 * @param node
	 * @param context
	 *
	 * @return The value.
	 */
	Value visit( Int node, Context context );

	/**
	 * Visit a money type node.
	 *
	 * @param node
	 * @param context
	 *
	 * @return The value.
	 */
	Value visit( Money node, Context context );

	/**
	 * Visit a string type node.
	 *
	 * @param node
	 * @param context
	 *
	 * @return The value.
	 */
	Value visit( Str node, Context context );
}
