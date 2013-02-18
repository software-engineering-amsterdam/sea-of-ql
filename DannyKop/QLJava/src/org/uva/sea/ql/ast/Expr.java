package org.uva.sea.ql.ast;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.SymbolTable;
import org.uva.sea.ql.visitor.Visitor;

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
	public <T> T accept(Visitor<T> visitor) { 
		return visitor.visit(this);
	}
	
	public abstract Type typeOf(SymbolTable st);
	
}
