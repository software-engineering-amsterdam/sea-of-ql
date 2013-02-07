package org.uva.sea.ql.visitor.printer;

import java.io.IOException;
import java.io.OutputStream;

import org.uva.sea.ql.ast.statement.Statement;

/**
 * Represents a pretty printer visitor.
 */
public class QLPrinter extends StatementWalker {
	/**
	 * Holds the output stream.
	 */
	private final OutputStream out;

	/**
	 * Constructs a new Printer visitor.
	 */
	public QLPrinter( OutputStream out ) {
		super( new ExpressionWalker() );
		this.out = out;
	}

	/**
	 * Converts the given (sub)tree of statements and expressions to a human-readable string.
	 *
	 * @param statement
	 *
	 * @return The tree as a string.
	 */
	private String getTreeAsString( Statement statement ) {
		return statement.accept( this );
	}

	/**
	 * Prints the given statement tree to the output stream.
	 *
	 * @param statement
	 *
	 * @throws IOException
	 */
	public void print( Statement statement ) throws IOException {
		String tree = this.getTreeAsString( statement );
		this.out.write( tree.getBytes() );
	}
}
