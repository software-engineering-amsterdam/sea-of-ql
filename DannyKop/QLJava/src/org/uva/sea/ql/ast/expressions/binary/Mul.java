package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class:
 * @author Danny
 *
 * Mul: multiply
 */
public class Mul extends BinExpr {
	/**
	 * Constructor
	 * @param l left
	 * @param r right
	 */
	public Mul(Expr l, Expr r) {
		super(l, r, "*");
	}
	/**
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	@Override
	public boolean isCompatibleTo(Expr t) {
		return (t.isCompatibleWithInt() || t.isCompatibleWithMoney());
	}
}
