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
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.ast.type.Type;

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
		// *before* indentation
		if ( node instanceof Statements ) {
			visit( (Statements) node );
			return;
		}
		
		indent();
		
		// *after* indentation
		
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
		else if ( node instanceof VarDeclaration ) {
			visit( (VarDeclaration) node );
		}
		else if ( node instanceof Type ) {
			visit( (Type) node );
		}
		else {
			System.err.println( "Unrecognized node type: " + node.getClass().getSimpleName() );
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
		put( node.getClass().getSimpleName().toUpperCase() );
		
		level++;
		
		visit( node.getExpression() );
		
		level--;
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
	 * Visit IF-statement.
	 * 
	 * @param node
	 */
	public void visit( If node ) {
		put( "IF" );
		
		level++;
		visit( node.getCondition() );
		level--;

		if ( node.getIfThen() != null ) {
			indent();
			put( "THEN" );
		
			level++;
			visit( node.getIfThen() );
			level--;
		}
		
		if ( node.getIfElse() != null ) {
			indent();
			put( "ELSE" );
			
			level++;
			visit( node.getIfElse() );
			level--;
		}
	}
	
	private void visit( VarDeclaration node ) {
		put( node.getClass().getSimpleName().toUpperCase() );

		level++;
		visit( node.getIdent() );
		visit( node.getType() );
		level--;
	}
	
	private void visit( Type node ) {
		put( node.getClass().getSimpleName().toUpperCase() );
	}
	
	private void visit( Statements node ) {
		for ( Statement statement : node ) {
			visit( statement );
		}
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
