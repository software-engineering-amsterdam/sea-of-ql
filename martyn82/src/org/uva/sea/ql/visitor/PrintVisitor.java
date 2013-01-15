package org.uva.sea.ql.visitor;

import java.io.IOException;
import java.io.OutputStream;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.value.Literal;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.Statement;

/**
 * Visitor that prints the AST.
 */
public class PrintVisitor implements Visitor {
	/**
	 * String used for indenting.
	 */
	private static final String INDENT = "  ";
	
	/**
	 * Holds the output stream to print to.
	 */
	private final OutputStream out;
	
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
		
		this.init();
	}
	
	/**
	 * Initializer.
	 */
	private void init() {
		put( "<AST>" );
		level++;
	}

	/**
	 * Puts data into the output stream.
	 * 
	 * @param data
	 */
	private void put( String data ) {
		try {
			out.write( data.getBytes() );
		}
		catch ( IOException e ) {
			// keep silent
		}
	}

	@Override
	public void visit( ASTNode node ) {
		indent();
		
		if ( node instanceof BinaryExpression ) {
			visit( (BinaryExpression) node );
		}
		else if ( node instanceof UnaryExpression ) {
			visit( (UnaryExpression) node );
		}
		else if ( node instanceof Literal ) {
			visit( (Literal) node );
		}
		else if ( node instanceof Ident ) {
			visit( (Ident) node );
		}
		else if ( node instanceof If ) {
			visit( (If) node );
		}
		else if ( node instanceof Statement ) {
			visit( (Statement) node );
		}
	}

	/**
	 * Visit binary expression.
	 * 
	 * @param node
	 */
	public void visit( BinaryExpression node ) {
		put( node.getClass().getSimpleName().toUpperCase() );
		
		level++;
		
		visit( node.getLhs() );
		visit( node.getRhs() );
		
		level--;
	}

	/**
	 * Visit unary expression.
	 * 
	 * @param node
	 */
	public void visit( UnaryExpression node ) {
	}

	/**
	 * Visit literal expression.
	 * 
	 * @param node
	 */
	public void visit( Literal node ) {
		put( node.getClass().getSimpleName().toUpperCase() );
		put( "(" );
		put( node.toString() );
		put( ")" );
	}
	
	/**
	 * Visit identifier expression.
	 * 
	 * @param node
	 */
	public void visit( Ident node ) {
		put( node.getClass().getSimpleName().toUpperCase() );
		put( "(" );
		put( node.getName() );
		put( ")" );
	}
	
	/**
	 * Visit general statement.
	 * 
	 * @param node
	 */
	public void visit( Statement node ) {
		put( "NULL" );
	}

	/**
	 * Visit IF-statement.
	 * 
	 * @param node
	 */
	public void visit( If node ) {
		put( "IF" );
		
		level++;
		visit( node.getCondition() );
		level--;

		indent();
		put( "THEN" );
		
		level++;
		indent();
		visit( node.getBody() );
		level--;
	}
	
	/**
	 * Appends indentation to the buffer.
	 */
	private void indent() {
		put( "\n" );
		
		for ( int i = 0; i < level; i++ ) {
			put( INDENT );
		}
	}
	
	/**
	 * Retrieves the output stream.
	 * 
	 * @return Output stream
	 */
	public OutputStream getOutput() {
		return out;
	}
}
