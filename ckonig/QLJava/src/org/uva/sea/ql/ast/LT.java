package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class LT extends BinaryExpr {
	public static final String str = "<";
	/**
	 * Less than
	 * @param left
	 * @param right
	 */
	public LT(Expr left, Expr right){
		super(left,right);
	}
}
