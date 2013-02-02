package org.uva.sea.ql.printer;

/**
 * Represents a pretty printer visitor.
 */
public class QLPrinter extends StatementPrinter {
	/**
	 * Constructs a new Printer visitor.
	 *
	 * @param context
	 */
	public QLPrinter( PrintContext context ) {
		super( context, new ExpressionPrinter( context ) );
	}
}
