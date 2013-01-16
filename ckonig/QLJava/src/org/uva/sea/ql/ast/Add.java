package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class Add extends BinaryExpr{
	public static final String str = "+";
	/**
	 * Addition
	 * @param left
	 * @param right
	 */
	public Add(Expr left, Expr right){
		super(left,right);
	}
}
