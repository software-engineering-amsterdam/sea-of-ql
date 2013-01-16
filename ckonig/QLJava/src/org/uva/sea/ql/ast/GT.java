package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class GT extends BinaryExpr{
	public static final String str = ">";
	/**
	 * Greater than
	 * @param left
	 * @param right
	 */
	public GT(Expr left, Expr right){
		super(left,right);
	}
}
