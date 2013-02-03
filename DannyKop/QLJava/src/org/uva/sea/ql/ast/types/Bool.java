package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.visitor.SymbolTable;


/**
 * class: Bool
 * @author Danny
 *
 */
public class Bool extends Expr {
	
	private final boolean value;
	
	/**
	 * Constructor
	 * @param v 
	 */
	public Bool(boolean v){
		this.value = v;
	}
	/**
	 * Constructor
	 * @param v
	 */
	public Bool(String v){
		this(Boolean.parseBoolean(v));
	}
	/**
	 * Constructor
	 * Used for typing
	 */
	public Bool(){
		this(false);
	}
	/**
	 * getValue()
	 * @return String - the boolean value
	 */
	//@Override	
	public String getValue(){
		return Boolean.toString(this.value);
	}
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
	public boolean isCompatibleTo(Expr t) {
		return t.isCompatibleWithBool();
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
