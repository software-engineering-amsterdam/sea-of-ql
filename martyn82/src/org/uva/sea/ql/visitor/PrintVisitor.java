package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.Literal;
import org.uva.sea.ql.ast.expression.UnaryExpression;

/**
 * Visitor that prints the AST.
 */
public class PrintVisitor extends Visitor {
	/**
	 * String used for indenting.
	 */
	private static final String INDENT = "  ";
	
	/**
	 * Holds the current nesting level.
	 */
	private int level;
	
	/**
	 * The buffer.
	 */
	private StringBuffer buffer;
	
	/**
	 * Constructs a new print visitor.
	 */
	public PrintVisitor() {
		this.level = 0;
		this.buffer = new StringBuffer();
	}
	
	/**
	 * Visits an arbitrary expression.
	 */
	public void visit( Expression expression ) {
		if ( expression instanceof BinaryExpression ) {
			this.level++;
			this.visitBinary( (BinaryExpression) expression );
			this.level--;
		}
		else if ( expression instanceof UnaryExpression ) {
			this.visitUnary( (UnaryExpression) expression );
		}
		else if ( expression instanceof Literal ) {
			this.visitLiteral( (Literal) expression );
		}
	
		else {
			this.visitExpression( expression );
		}
	}
	
	/**
	 * Visits a literal value expression.
	 * 
	 * @param expression
	 */
	private void visitLiteral( Literal expression ) {
		buffer.append( expression.getClass().getSimpleName().toUpperCase() );
		buffer.append( "(" );
		buffer.append( expression.toString() );
		buffer.append( ")" );
	}
	
	/**
	 * Visits a regular expression.
	 * 
	 * @param expression
	 */
	private void visitExpression( Expression expression ) {
		buffer.append( expression.toString() );
	}
	
	/**
	 * Visits an unary expression.
	 * 
	 * @param expression
	 */
	private void visitUnary( UnaryExpression expression ) {
		buffer.append( expression.getClass().getSimpleName().toUpperCase() );
		buffer.append( "( " );
		this.visit( expression.getExpression() );
		buffer.append( " )" );
	}
	
	/**
	 * Visits a binary expression.
	 * 
	 * @param expression
	 */
	private void visitBinary( BinaryExpression expression ) {
		if ( buffer.length() > 0 ) {
			buffer.append( "\n" );
		}
		
		this.indent( this.level );
		
		buffer.append( expression.getClass().getSimpleName().toUpperCase() );
		buffer.append( "( " );

		this.visit( expression.getLhs() );
		buffer.append( " " );
		
		this.visit( expression.getRhs() );

		buffer.append( " )" );
	}
	
	/**
	 * Appends indentation to the buffer.
	 * 
	 * @param levels
	 */
	private void indent( int levels ) {
		for ( int i = 0; i < ( levels - 1); i++ ) {
			buffer.append( INDENT );
		}
	}
	
	@Override
	public String toString() {
		return buffer.toString();
	}
}
