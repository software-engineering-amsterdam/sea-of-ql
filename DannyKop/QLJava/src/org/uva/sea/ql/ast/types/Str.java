package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: Str
 * @author Danny
 *
 * Str: string
 */
public class Str extends Expr implements Type<String> {
	
	private final String value;
	
	/**
	 * Constructor
	 * @param v - the string
	 */
	public Str(String v) {
		this.value = v;
	}
	/**
	 * getValue()
	 * @return String - the string
	 */
	@Override
	public String getValue(){
		return this.value;
	}
	/**
	 * getType()
	 * @return String - the type description of the implemented type
	 */
	@Override
	public String getType() {
		return "Str";
	}
}
