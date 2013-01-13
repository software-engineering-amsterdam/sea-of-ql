package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents an expression.
 */
abstract public class Expression implements ASTNode {
	public final char TOKEN = '\0';
	private Expression parent;
	
	public void setParent( Expression parent ) {
		this.parent = parent;
	}
	
	public Expression getParent() {
		return this.parent;
	}
	
	/**
	 * Accepts a visitor.
	 * 
	 * @param visitor The visitor.
	 * 
	 * @return The value the expression produces.
	 */
	abstract public void accept( Visitor visitor );
}
