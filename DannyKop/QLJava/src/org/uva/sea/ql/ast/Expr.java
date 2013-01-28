package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.visitor.Visitor;

/**
 * abstract class: Expr
 * @author Danny
 *
 */
public abstract class Expr implements ASTNode {

	/**
	 * accept()
	 * @param visitor
	 */
	@Override
	public void accept(Visitor visitor) { 
		// Check if this works correctly or that the accept method should be implemented on each derivation of expr
		visitor.visit(this);
	}
	
}
