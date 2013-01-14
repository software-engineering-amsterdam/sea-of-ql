package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class Or extends BinaryExpr {
	public static final String str = "||";
	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Or(Expr left, Expr right){
		super(left,right);
	}
}
