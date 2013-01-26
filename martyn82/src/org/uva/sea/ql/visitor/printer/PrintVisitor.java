package org.uva.sea.ql.visitor.printer;

import java.io.IOException;
import java.io.OutputStream;

import org.uva.sea.ql.ast.Node;
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
import org.uva.sea.ql.ast.statement.Else;
import org.uva.sea.ql.ast.statement.ElseIf;
import org.uva.sea.ql.ast.statement.ElseIfs;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Visitor that prints the AST.
 */
public class PrintVisitor extends NodeVisitor<Boolean> {
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
	private void writeName( Node node ) {
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
	public Boolean visit( LogicalExpression node ) {
		writeName( node );

		level++;

		indent();
		node.getLhs().accept( this );

		indent();
		node.getRhs().accept( this );

		level--;

		return true;
	}

	@Override
	public Boolean visit( ArithmeticExpression node ) {
		writeName( node );

		level++;

		indent();
		node.getLhs().accept( this );

		indent();
		node.getRhs().accept( this );

		level--;

		return true;
	}

	@Override
	public Boolean visit( UnaryExpression node ) {
		writeName( node );

		level++;

		indent();
		node.getExpression().accept( this );

		level--;

		return true;
	}

	@Override
	public Boolean visit( UnaryNumericExpression node ) {
		writeName( node );

		level++;

		indent();
		node.getExpression().accept( this );

		level--;

		return true;
	}

	@Override
	public Boolean visit( Str node ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Money node ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Int node ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Bool node ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Ident node ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Else node ) {
		indent();
		write( "ELSE" );

		level++;

		indent();
		node.getBody().accept( this );

		level--;

		return true;
	}

	@Override
	public Boolean visit( IfThenElse node ) {
		indent();
		write( "IF" );

		level++;

		indent();
		node.getCondition().accept( this );

		level--;

		indent();
		write( "THEN" );

		if ( node.hasIfBody() ) {
			level++;

			indent();
			node.getIfBody().accept( this );

			level--;
		}

		if ( node.hasElseIfs() ) {
			node.getElseIfs().accept( this );
		}

		if ( node.hasElse() ) {
			node.getElse().accept( this );
		}

		return true;
	}

	@Override
	public Boolean visit( ElseIfs node ) {
		for ( ElseIf elseIf : node ) {
			elseIf.accept( this );
		}

		return true;
	}

	@Override
	public Boolean visit( ElseIf node ) {
		indent();
		write( "ELSEIF" );

		level++;

		indent();
		node.getCondition().accept( this );

		level--;

		indent();
		write( "THEN" );

		level++;

		node.getBody().accept( this );

		level--;

		return true;
	}

	@Override
	public Boolean visit( VarDeclaration node ) {
		writeName( node );

		level++;

		indent();
		node.getIdent().accept( this );

		indent();
		write( node.getType().getClass().getSimpleName().toUpperCase() );

		level--;

		return true;
	}

	@Override
	public Boolean visit( Assignment node ) {
		writeName( node );

		level++;

		indent();
		node.getIdent().accept( this );

		indent();
		node.getExpression().accept( this );

		level--;

		return true;
	}

	@Override
	public Boolean visit( FormDeclaration node ) {
		writeName( node );

		level++;

		indent();
		node.getIdent().accept( this );

		indent();
		node.getStatements().accept( this );

		level--;

		return true;
	}

	@Override
	public Boolean visit( QuestionDeclaration node ) {
		indent();
		writeName( node );

		level++;

		indent();
		node.getName().accept( this );

		indent();
		node.getDeclaration().accept( this );

		level--;

		return true;
	}

	@Override
	public Boolean visit( Statements node ) {
		for ( Statement statement : node ) {
			statement.accept( this );
		}

		return true;
	}

	@Override
	public Boolean visit( ComparisonExpression node ) {
		writeName( node );

		level++;

		indent();
		node.getLhs().accept( this );

		indent();
		node.getRhs().accept( this );

		level--;

		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.type.Bool node ) {
		writeName( node );
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.type.Int node ) {
		writeName( node );
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.type.Str node ) {
		writeName( node );
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.type.Money node ) {
		writeName( node );
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.type.Number node ) {
		writeName( node );
		return true;
	}
}
