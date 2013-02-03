package org.uva.sea.ql.ast;
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
	/**
	 * getType
	 * @param st
	 * @return Type of the element
	 */
	public abstract Expr getType(SymbolTable st);
	/**
	 * isCompatibleWithInt
	 * @return 
	 */
	public boolean isCompatibleWithInt() { 
		return false; 
	}
	/**
	 * isCompatibleWithMoney
	 * @return
	 */
	public boolean isCompatibleWithMoney() { 
		return false; 
	}
	/**
	 * isCompatibleWithStr
	 * @return
	 */
	public boolean isCompatibleWithStr() { 
		return false; 
	}
	/**
	 * isCompatibleWithBool
	 * @return
	 */
	public boolean isCompatibleWithBool() { 
		return false; 
	}
	/**
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	public abstract boolean isCompatibleTo(Expr t);
}
