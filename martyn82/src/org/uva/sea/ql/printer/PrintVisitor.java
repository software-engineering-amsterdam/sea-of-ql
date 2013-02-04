package org.uva.sea.ql.printer;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.literal.Literal;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

/**
 * Visitor that prints the AST.
 */
abstract public class PrintVisitor extends ASTNodeVisitor<Boolean> implements IPrintContext {
	/**
	 * Holds the context.
	 */
	private final PrintContext context;

	/**
	 * Constructs a new PrintVisitor.
	 *
	 * @param context
	 */
	public PrintVisitor( PrintContext context ) {
		this.context = context;
	}

	/**
	 * Retrieves the context.
	 *
	 * @return The context.
	 */
	public PrintContext getContext() {
		return this.context;
	}

	@Override
	public void indent() {
		this.context.indent();
	}

	@Override
	public void increaseLevel() {
		this.context.increaseLevel();
	}

	@Override
	public void decreaseLevel() {
		this.context.decreaseLevel();
	}

	@Override
	public void write( String data ) {
		this.context.write( data );
	}

	@Override
	public void writeAtomic( Ident node ) {
		this.context.writeAtomic( node );
	}

	@Override
	public void writeAtomic( Literal node ) {
		this.context.writeAtomic( node );
	}

	@Override
	public void writeName( Node node ) {
		this.context.writeName( node );
	}
}
