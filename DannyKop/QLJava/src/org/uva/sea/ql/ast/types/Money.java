package org.uva.sea.ql.ast.types;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.Expr;
/**
 * Class: Money
 * @author Danny
 *
 */
public class Money extends Expr implements Type<BigDecimal> {

	private final BigDecimal value;
	/**
	 * Constructor
	 * @param v - value
	 */
	public Money(BigDecimal v){
		this.value = v;
	}
	/**
	 * getValue()
	 * @return Double - the double value
	 */
	@Override	
	public BigDecimal getValue(){
		return this.value;
	}
	
	/**
	 * getType()
	 * @return String - the type description of the implemented type
	 */	
	@Override
	public String getType() {
		return "money";
	}

}
