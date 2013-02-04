package org.uva.sea.ql.printer;

import java.io.IOException;
import java.io.OutputStream;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.literal.Literal;

/**
 * Represents a pretty printer context.
 */
public class PrintContext implements IPrintContext {
	/**
	 * String used for indenting.
	 */
	private static final String INDENT = "  ";

	/**
	 * String template used for printing atomic nodes.
	 */
	private static final String TPL_ATOMIC_NODE = "%s(%s)";

	/**
	 * Holds the output stream to print to.
	 */
	private final OutputStream out;

	/**
	 * Holds a value to determine whether there were bytes written to the output stream.
	 */
	private boolean empty;

	/**
	 * Holds the current nesting level.
	 */
	private int level;

	/**
	 * Constructs a new print visitor.
	 *
	 * @param out
	 */
	public PrintContext( OutputStream out ) {
		this.out = out;
		this.level = 0;
		this.empty = true;
	}

	/**
	 * Retrieves the output stream.
	 *
	 * @return Output stream
	 */
	public OutputStream getOutput() {
		return this.out;
	}

	@Override
	public void indent() {
		if ( !this.empty ) {
			this.write( "\n" );
		}

		StringBuilder sb = new StringBuilder();

		for ( int i = 0; i < this.level; i++ ) {
			sb.append( INDENT );
		}

		this.write( sb.toString() );
	}

	@Override
	public void increaseLevel() {
		this.level++;
	}

	@Override
	public void decreaseLevel() {
		this.level--;
	}

	@Override
	public void write( String data ) {
		try {
			this.out.write( data.getBytes() );
			this.empty = false;
		}
		catch ( IOException e ) {
			e.printStackTrace();
			throw new RuntimeException( e );
		}
	}

	@Override
	public void writeName( Node node ) {
		this.write( node.toString() );
	}

	@Override
	public void writeAtomic( Literal node ) {
		this.write(
			String.format(
				TPL_ATOMIC_NODE,
				node.getClass().getSimpleName().toUpperCase(),
				node.toString()
			)
		);
	}

	@Override
	public void writeAtomic( Ident node ) {
		this.write(
			String.format(
				TPL_ATOMIC_NODE,
				node.toString(),
				node.getName()
			)
		);
	}
}
