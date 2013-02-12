package org.uva.sea.ql.ast.types;

/**
 * Class: Str
 * @author Danny
 *
 * Str: string
 */
public class StrType extends Type  {
	
	/**
	 * isCompatibleWithStr
	 * @return 
	 */
	public boolean isCompatibleWithStr(){
		return true;
	}
	/**
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleWithStr();
	}
}
