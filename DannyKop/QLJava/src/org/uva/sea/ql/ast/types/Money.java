package org.uva.sea.ql.ast.types;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.visitor.SymbolTable;

/**
 * Class: Money
 * @author Danny
 *
 */
public class Money extends Expr {

	private final BigDecimal value;
	/**
	 * Constructor
	 * @param v - value
	 */
	public Money(BigDecimal v){
		this.value = v;
	}
	/**
	 * Constructor
	 * @param v
	 */
	public Money(String v){
		this(new BigDecimal(v));
	}
	/**
	 * Constructor
	 * Used for typing
	 */
	public Money(){
		this(new BigDecimal(0));
	}
	/**
	 * getValue()
	 * @return Double - the double value
	 */
	public String getValue(){
		return value.toString();
	}
	/**
	 * isCompatibleWithInt
	 * @return 
	 */
	public boolean isCompatibleWithInt(){
		return true;
	}	
	/**
	 * isCompatibleWithMoney
	 * @return 
	 */
	public boolean isCompatibleWithMoney(){
		return true;
	}
	/**
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	@Override
	public boolean isCompatibleTo(Expr t) {
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
