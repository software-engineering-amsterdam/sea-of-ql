package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class BinaryExpr extends Expr {
	private Expr left;
	private Expr right;

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public BinaryExpr(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}
	/**
	 * 
	 * @return
	 */
	public Expr getRight() {
		return right;
	}
	/**
	 * 
	 * @return
	 */
	public Expr getLeft() {
		return left;
	}
}
