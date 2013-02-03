package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.visitor.SymbolTable;

/**
 * Class: Str
 * @author Danny
 *
 * Str: string
 */
public class Str extends Expr {
	
	private final String value;
	
	/**
	 * Constructor
	 * @param v - the string
	 */
	public Str(String v) {
		this.value = v;
	}
	/**
	 * Constructor
	 * Used for typing
	 */
	public Str(){
		this("");
	}
	/**
	 * getValue()
	 * @return String - the string
	 */
	//@Override
	public String getValue(){
		return this.value;
	}	
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
	public boolean isCompatibleTo(Expr t) {
		return t.isCompatibleWithStr();
	}
	/**
	 * getType
	 * @param st - the table to check for the type
	 * @return Expr - type
	 */
	@Override
	public Expr getType(SymbolTable st) {
		return this;
	}
}
