package org.uva.sea.ql.printer;

/**
 * Represents a pretty printer visitor.
 */
public class Printer extends StatementPrinter {
	/**
	 * Constructs a new Printer visitor.
	 *
	 * @param context
	 */
	public Printer( PrintContext context ) {
		super( context, new ExpressionPrinter( context ) );
	}
}
