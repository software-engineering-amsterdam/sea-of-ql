package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class And extends BinaryExpr {
	public static final String str = "&&";
	/**
	 * And
	 * @param left
	 * @param right
	 */
	public And(Expr left, Expr right){
		super(left, right);
	}
}
