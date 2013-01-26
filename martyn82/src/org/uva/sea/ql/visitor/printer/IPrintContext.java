package org.uva.sea.ql.visitor.printer;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.literal.Literal;

/**
 * Defines the interface of the pretty printer context.
 */
public interface IPrintContext {
	/**
	 * Appends indentation to the output.
	 */
	void indent();

	/**
	 * Increases indentation level.
	 */
	void increaseLevel();

	/**
	 * Decreases indentation level.
	 */
	void decreaseLevel();

	/**
	 * Puts data into the output stream.
	 *
	 * @param data
	 */
	void write( String data );

	/**
	 * Writes an atomic node to output stream.
	 *
	 * @param node
	 */
	void writeAtomic( Ident node );

	/**
	 * Writes an atomic node to output stream.
	 *
	 * @param node
	 */
	void writeAtomic( Literal node );

	/**
	 * Writes a node name to output.
	 *
	 * @param node
	 */
	void writeName( Node node );
}
