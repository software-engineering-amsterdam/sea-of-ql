package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class Int extends Expr {

	private final int value;
	/**
	 * 
	 * @param n
	 */
	public Int(int n) {
		this.value = n;
	}
	/**
	 * 
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
}
