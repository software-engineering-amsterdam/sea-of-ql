package org.uva.sea.ql.ast.types;

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
		// TODO Auto-generated method stub
		return t.isCompatibleWithInt();
	}
}
