package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: Int
 * @author Danny
 *
 */
public class Int extends Expr implements Type<Integer>  {

	private final int value;

	/**
	 * Constructor
	 * @param v - int value
	 */
	public Int(int v) {
		this.value = v;
	}
	/**
	 * getValue()
	 * @return Integer - the int value
	 */
	@Override
	public Integer getValue() {
		return value;
	}
	/**
	 * getType()
	 * @return String - the type description of the implemented type
	 */
	@Override
	public String getType() {
		return "Int";
	}	
}
