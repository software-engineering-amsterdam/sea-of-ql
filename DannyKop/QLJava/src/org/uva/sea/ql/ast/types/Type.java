package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNode;

/**
 * interface: Type
 * @author Danny
 * 
 *
 */
public interface Type <T> extends ASTNode {
	
	/**
	 * getType()
	 * @return String - the type description of the implemented type
	 */
	public String getType();
	
	/**
	 * getValue()
	 * @return T - the value of the type
	 */
	public T getValue();
	
}
