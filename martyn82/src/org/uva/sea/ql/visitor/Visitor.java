package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.value.Literal;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.ast.type.Type;

/**
 * Visitor for printing AST.
 */
abstract public class Visitor {
	/**
	 * Visit an expression.
	 * 
	 * @param node
	 */
	public void visit( Expression node ) {
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
		else {
			System.err.println( node.getClass().getName() );
		}
	}
	
	/**
	 * Visit a group of statements.
	 * 
	 * @param node
	 */
	public void visit( Statements node ) {
		for ( Statement statement : node ) {
			visit( statement );
		}
	}
	
	/**
	 * Visit a statement.
	 * 
	 * @param node
	 */
	public void visit( Statement node ) {
		if ( node instanceof VarDeclaration ) {
			visit( (VarDeclaration) node );
		}
		else if ( node instanceof If ) {
			visit( (If) node );
		}
		else if ( node instanceof Assignment ) {
			visit( (Assignment) node );
		}
		else {
			System.out.println( node.getClass().getName() );
		}
	}
	
	/**
	 * Visit binary expression.
	 * 
	 * @param node
	 */
	abstract public void visit( BinaryExpression node );

	/**
	 * Visit unary expression.
	 * 
	 * @param node
	 */
	abstract public void visit( UnaryExpression node );

	/**
	 * Visit literal expression.
	 * 
	 * @param node
	 */
	abstract public void visit( Literal node );
	
	/**
	 * Visit identifier expression.
	 * 
	 * @param node
	 */
	abstract public void visit( Ident node );
	
	/**
	 * Visit IF-statement.
	 * 
	 * @param node
	 */
	abstract public void visit( If node );
	
	/**
	 * Visit a variable declaration.
	 * 
	 * @param node
	 */
	abstract public void visit( VarDeclaration node );
	
	/**
	 * Visit a Type node.
	 * 
	 * @param node
	 */
	abstract public void visit( Type node );
	
	/**
	 * Visit an assignment.
	 * 
	 * @param node
	 */
	abstract public void visit( Assignment node );
}
