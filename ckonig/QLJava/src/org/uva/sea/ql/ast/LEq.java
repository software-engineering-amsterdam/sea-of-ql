package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class LEq extends BinaryExpr{
	public static final String str = "<=";
	/**
	 * Less than or equals
	 * @param left
	 * @param right
	 */
	public LEq(Expr left, Expr right){
		super(left,right);
	}
}
