package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class GEq extends BinaryExpr{
	public static final String str = ">=";
	/**
	 * Greater than or equals 
	 * @param left
	 * @param right
	 */
	public GEq(Expr left, Expr right){
		super(left,right);
	}
}
