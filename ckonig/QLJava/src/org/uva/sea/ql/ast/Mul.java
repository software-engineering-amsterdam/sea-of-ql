package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class Mul extends BinaryExpr {
	public static final String str = "*";
	/**
	 * Multiplication
	 * @param left
	 * @param right
	 */
	public Mul(Expr left, Expr right) {
		super(left, right);
	}
}
