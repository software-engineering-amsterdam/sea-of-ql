package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.TypeVisitor;

/**
 * Class: Int
 * @author Danny
 *
 */
public class IntType extends Type {

	/**
	 * isCompatibleWithInt
	 */
	public boolean isCompatibleWithInt(){
		return true;
	}
	/**
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleWithInt();
	}
	@Override
	public <T> T accept(TypeVisitor<T> visitor){
		return visitor.visit(this);
	}
}
