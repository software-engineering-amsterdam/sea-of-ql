package org.uva.sea.ql.visitor.print;

import java.io.IOException;
import java.io.OutputStream;

import org.uva.sea.ql.ast.INode;
import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.ComparisonExpression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.expression.value.Int;
import org.uva.sea.ql.ast.expression.value.Literal;
import org.uva.sea.ql.ast.expression.value.Money;
import org.uva.sea.ql.ast.expression.value.Str;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.evaluate.Context;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Visitor that prints the AST.
 */
public class PrintVisitor implements INodeVisitor {
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
	public PrintVisitor( OutputStream out ) {
		this.out = out;
		this.level = 0;
		this.empty = true;
	}

	/**
	 * Appends indentation to the buffer.
	 */
	private void indent() {
		if ( !empty ) {
			write( "\n" );
		}

		StringBuilder sb = new StringBuilder();

		for ( int i = 0; i < level; i++ ) {
			sb.append( INDENT );
		}

		write( sb.toString() );
	}

	/**
	 * Retrieves the output stream.
	 *
	 * @return Output stream
	 */
	public OutputStream getOutput() {
		return out;
	}

	/**
	 * Puts data into the output stream.
	 *
	 * @param data
	 */
	private void write( String data ) {
		try {
			out.write( data.getBytes() );
			empty = false;
		}
		catch ( IOException e ) {
			// keep silent
		}
	}

	/**
	 * Writes a node name to output.
	 *
	 * @param node
	 */
	private void writeName( INode node ) {
		write( node.getClass().getSimpleName().toUpperCase() );
	}

	/**
	 * Writes an atomic node to output stream.
	 *
	 * @param node
	 */
	private void writeAtomic( Literal node ) {
		write(
			String.format(
				TPL_ATOMIC_NODE,
				node.getClass().getSimpleName().toUpperCase(),
				node.toString()
			)
		);
	}

	/**
	 * Writes an atomic node to output stream.
	 *
	 * @param node
	 */
	private void writeAtomic( Ident node ) {
		write(
			String.format(
				TPL_ATOMIC_NODE,
				node.getClass().getSimpleName().toUpperCase(),
				node.getName()
			)
		);
	}

	@Override
	public Value visit( LogicalExpression node, Context context ) {
		writeName( node );

		level++;

		indent();
		node.getLhs().accept( this, context );

		indent();
		node.getRhs().accept( this, context );

		level--;

		return null;
	}

	@Override
	public Value visit( ArithmeticExpression node, Context context ) {
		writeName( node );

		level++;

		indent();
		node.getLhs().accept( this, context );

		indent();
		node.getRhs().accept( this, context );

		level--;

		return null;
	}

	@Override
	public Value visit( UnaryExpression node, Context context ) {
		writeName( node );

		level++;

		indent();
		node.getExpression().accept( this, context );

		level--;

		return null;
	}

	@Override
	public Value visit( UnaryNumericExpression node, Context context ) {
		writeName( node );

		level++;

		indent();
		node.getExpression().accept( this, context );

		level--;

		return null;
	}

	@Override
	public Value visit( Str node, Context context ) {
		writeAtomic( node );
		return null;
	}

	@Override
	public Value visit( Money node, Context context ) {
		writeAtomic( node );
		return null;
	}

	@Override
	public Value visit( Int node, Context context ) {
		writeAtomic( node );
		return null;
	}

	@Override
	public Value visit( Bool node, Context context ) {
		writeAtomic( node );
		return null;
	}

	@Override
	public Value visit( Ident node, Context context ) {
		writeAtomic( node );
		return null;
	}

	@Override
	public Value visit( IfThenElse node, Context context ) {
		indent();
		write( "IF" );

		level++;

		indent();
		node.getCondition().accept( this, context );

		level--;

		if ( node.getIfThen() != null ) {
			indent();
			write( "THEN" );

			level++;

			indent();
			node.getIfThen().accept( this, context );

			level--;
		}

		if ( node.getIfElse() != null ) {
			indent();
			write( "ELSE" );

			level++;

			indent();
			node.getIfElse().accept( this, context );

			level--;
		}

		return null;
	}

	@Override
	public Value visit( VarDeclaration node, Context context ) {
		writeName( node );

		level++;

		indent();
		node.getIdent().accept( this, context );

		indent();
		write( node.getType().name() );

		level--;

		return null;
	}

	@Override
	public Value visit( Assignment node, Context context ) {
		writeName( node );

		level++;

		indent();
		node.getIdent().accept( this, context );

		indent();
		node.getExpression().accept( this, context );

		level--;

		return null;
	}

	@Override
	public Value visit( FormDeclaration node, Context context ) {
		writeName( node );

		level++;

		indent();
		node.getIdent().accept( this, context );

		indent();
		node.getStatements().accept( this, context );

		level--;

		return null;
	}

	@Override
	public Value visit( QuestionDeclaration node, Context context ) {
		indent();
		writeName( node );

		level++;

		indent();
		node.getName().accept( this, context );

		indent();
		node.getDeclaration().accept( this, context );

		level--;

		return null;
	}

	@Override
	public Value visit( ComparisonExpression node, Context context ) {
		writeName( node );

		level++;

		indent();
		node.getLhs().accept( this, context );

		indent();
		node.getRhs().accept( this, context );

		level--;

		return null;
	}
}
