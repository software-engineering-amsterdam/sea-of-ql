package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.TypeVisitor;

/**
 * class: Bool
 * @author Danny
 *
 */
public class BoolType extends Type {
	/**
	 * isCompatibleWithBool
	 * @return 
	 */
	@Override
	public boolean isCompatibleWithBool(){
		return true;
	}
	/**
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleWithBool();
	}
	@Override
	public <T> T accept(TypeVisitor<T> visitor){
		return visitor.visit(this);
	}
}
