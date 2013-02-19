package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.TypeVisitor;
import org.uva.sea.ql.visitor.Visitor;

public abstract class Type implements ASTNode {
	/**
	 * isCompatibleWithInt
	 * @return 
	 */
	public boolean isCompatibleWithInt() { 
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
	public abstract boolean isCompatibleTo(Type t);
	/**
	 * accept()
	 * @param visitor
	 */
	@Override
	public <T> T accept(Visitor<T> visitor){
		return visitor.visit(this);
	}
	public <T> T accept(TypeVisitor<T> visitor){
		return visitor.visit(this);
	}
}
