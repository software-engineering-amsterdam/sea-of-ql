package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class Div extends BinaryExpr{
	public static final String str = "/";
	/**
	 * Division
	 * @param left
	 * @param right
	 */
	public Div(Expr left, Expr right){
		super(left,right);
	}
}
