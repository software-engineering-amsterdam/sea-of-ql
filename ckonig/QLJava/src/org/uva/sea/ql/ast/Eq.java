package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class Eq extends BinaryExpr {
	public static final String str = "==";
	/**
	 * Equals
	 * @param left
	 * @param right
	 */
	public Eq(Expr left, Expr right){
		super(left,right);
	}
}
