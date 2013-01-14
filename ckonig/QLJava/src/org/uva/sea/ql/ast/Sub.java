package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class Sub extends BinaryExpr {
	public static final String str = "-";
	/**
	 * Subtraction
	 * @param left
	 * @param right
	 */
	public Sub(Expr left, Expr right){
		super(left,right);
	}
}
