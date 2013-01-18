package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class NEq extends BinaryExpr{
	public static final String str = "!=";
	/**
	 * Not equals
	 * @param left
	 * @param right
	 */
	public NEq(Expr left, Expr right){
		super(left,right);
	}
}
