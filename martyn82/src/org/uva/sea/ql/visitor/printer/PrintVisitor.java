package org.uva.sea.ql.visitor.printer;

import java.io.IOException;
import java.io.OutputStream;

import org.uva.sea.ql.ast.INode;
import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.ComparisonExpression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Literal;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Visitor that prints the AST.
 */
public class PrintVisitor implements INodeVisitor<Boolean> {
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
	public Boolean visit( LogicalExpression node, Environment context ) {
		writeName( node );

		level++;

		indent();
		node.getLhs().accept( this, context );

		indent();
		node.getRhs().accept( this, context );

		level--;

		return true;
	}

	@Override
	public Boolean visit( ArithmeticExpression node, Environment context ) {
		writeName( node );

		level++;

		indent();
		node.getLhs().accept( this, context );

		indent();
		node.getRhs().accept( this, context );

		level--;

		return true;
	}

	@Override
	public Boolean visit( UnaryExpression node, Environment context ) {
		writeName( node );

		level++;

		indent();
		node.getExpression().accept( this, context );

		level--;

		return true;
	}

	@Override
	public Boolean visit( UnaryNumericExpression node, Environment context ) {
		writeName( node );

		level++;

		indent();
		node.getExpression().accept( this, context );

		level--;

		return true;
	}

	@Override
	public Boolean visit( Str node, Environment context ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Money node, Environment context ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Int node, Environment context ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Bool node, Environment context ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Ident node, Environment context ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( IfThenElse node, Environment context ) {
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

		return true;
	}

	@Override
	public Boolean visit( VarDeclaration node, Environment context ) {
		writeName( node );

		level++;

		indent();
		node.getIdent().accept( this, context );

		indent();
		write( node.getType().getClass().getSimpleName().toUpperCase() );

		level--;

		return true;
	}

	@Override
	public Boolean visit( Assignment node, Environment context ) {
		writeName( node );

		level++;

		indent();
		node.getIdent().accept( this, context );

		indent();
		node.getExpression().accept( this, context );

		level--;

		return true;
	}

	@Override
	public Boolean visit( FormDeclaration node, Environment context ) {
		writeName( node );

		level++;

		indent();
		node.getIdent().accept( this, context );

		indent();
		node.getStatements().accept( this, context );

		level--;

		return true;
	}

	@Override
	public Boolean visit( QuestionDeclaration node, Environment context ) {
		indent();
		writeName( node );

		level++;

		indent();
		node.getName().accept( this, context );

		indent();
		node.getDeclaration().accept( this, context );

		level--;

		return true;
	}

	@Override
	public Boolean visit( Statements node, Environment context ) {
		for ( Statement statement : node ) {
			statement.accept( this, context );
		}

		return true;
	}

	@Override
	public Boolean visit( ComparisonExpression node, Environment context ) {
		writeName( node );

		level++;

		indent();
		node.getLhs().accept( this, context );

		indent();
		node.getRhs().accept( this, context );

		level--;

		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.type.Bool node, Environment context ) {
		writeName( node );
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.type.Int node, Environment context ) {
		writeName( node );
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.type.Str node, Environment context ) {
		writeName( node );
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.type.Money node, Environment context ) {
		writeName( node );
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.type.Number node, Environment context ) {
		writeName( node );
		return true;
	}
}
