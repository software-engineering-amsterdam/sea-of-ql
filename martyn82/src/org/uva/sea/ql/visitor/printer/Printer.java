package org.uva.sea.ql.visitor.printer;

import java.io.OutputStream;

/**
 * Represents a pretty printer visitor.
 */
public class Printer extends StatementPrinter {
	/**
	 * Constructs a new Printer visitor.
	 *
	 * @param out
	 */
	public Printer( OutputStream out ) {
		super( out, new ExpressionPrinter( out ) );
	}
}
