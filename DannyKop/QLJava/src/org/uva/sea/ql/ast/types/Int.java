package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.visitor.SymbolTable;

/**
 * Class: Int
 * @author Danny
 *
 */
public class Int extends Expr {

	private final int value;

	/**
	 * Constructor
	 * @param v - int value
	 */
	public Int(int v) {
		this.value = v;
	}
	/**
	 * Constructor
	 * Used for typing
	 */
	public Int(){
		this(-1);
	}
	/**
	 * getValue()
	 * @return String - the int value
	 */
	public String getValue() {
		return Integer.toString(this.value);
	}
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
	public boolean isCompatibleTo(Expr t) {
		// TODO Auto-generated method stub
		return (t.isCompatibleWithInt() || t.isCompatibleWithMoney());
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
