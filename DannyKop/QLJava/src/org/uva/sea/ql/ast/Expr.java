package org.uva.sea.ql.ast;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.SymbolTable;
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
		visitor.visit(this);
	}
	
	public abstract Type typeOf(SymbolTable st);
	
}
