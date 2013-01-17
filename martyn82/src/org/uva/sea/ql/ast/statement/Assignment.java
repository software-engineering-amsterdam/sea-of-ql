package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Ident;

/**
 * Represents an assignment.
 */
public class Assignment extends Statement {
	/**
	 * Holds the identifier.
	 */
	private final Ident ident;
	
	/**
	 * Holds the expression.
	 */
	private final Expression expression;
	
	/**
	 * Constructs a new Assignment instance.
	 * 
	 * @param ident The identifier to assign a value to.
	 * @param expression The expression that represents the value.
	 */
	public Assignment( Ident ident, Expression expression ) {
		this.ident = ident;
		this.expression = expression;
	}
	
	/**
	 * Retrieves the identifier.
	 * 
	 * @return The identifier.
	 */
	public Ident getIdent() {
		return this.ident;
	}
	
	/**
	 * Retrieves the expression.
	 * 
	 * @return The expression.
	 */
	public Expression getExpression() {
		return this.expression;
	}
}
