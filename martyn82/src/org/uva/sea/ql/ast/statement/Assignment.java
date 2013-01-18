package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents an assignment.
 */
public class Assignment extends Statement {
	/**
	 * Holds the left-hand side.
	 */
	private final Ident lhs;
	
	/**
	 * Holds the right-hand side.
	 */
	private final Expression rhs;
	
	/**
	 * Constructs a new Assignment instance.
	 * 
	 * @param lhs The left-hand side to assign a value to.
	 * @param rhs The right-hand side that evaluates to the value.
	 */
	public Assignment( Ident lhs, Expression rhs ) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	/**
	 * Retrieves the left-hand side.
	 * 
	 * @return The left-hand side.
	 */
	public Ident getLhs() {
		return this.lhs;
	}
	
	/**
	 * Retrieves the right-hand side.
	 * 
	 * @return The right-hand side.
	 */
	public Expression getRhs() {
		return this.rhs;
	}
	
	@Override
	public void accept( NodeVisitor visitor ) {
		visitor.visit( this );
	}

}
