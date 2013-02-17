package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.TypeVisitor;

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
	@Override
	public <T> T accept(TypeVisitor<T> visitor){
		return visitor.visit(this);
	}
}
