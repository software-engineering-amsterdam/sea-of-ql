package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Expr;

/**
 * class: Bool
 * @author Danny
 *
 */
public class Bool extends Expr implements Type<Boolean> {
	
	private final boolean value;
	
	/**
	 * Bool
	 * @param v 
	 */
	public Bool(boolean v){
		this.value = v;
	}
	/**
	 * getValue()
	 * @return Boolean - the boolean value
	 */
	@Override	
	public Boolean getValue(){
		return value;
	}
	
	/**
	 * getType
	 * @return String - the type description of the implemented type
	 */
	@Override
	public String getType(){
		return "bool";
	}
}
