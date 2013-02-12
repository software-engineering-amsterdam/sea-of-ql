package org.uva.sea.ql.ast.types;

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
}
