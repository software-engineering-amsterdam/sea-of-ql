package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: NEq
 * @author Danny
 *
 * NEq: != (not equal)
 */
public class NEq extends BinExpr {
	/**
	 * Constructor
	 * @param l left
	 * @param r right
	 */
	public NEq(Expr l, Expr r) {
		super(l, r, "!=");
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
	/**
	 * isCompatibleWithInt
	 * @return 
	 */
	@Override
	public boolean isCompatibleWithInt() { 
		return true; 
	}
	/**
	 * isCompatibleWithMoney
	 * @return
	 */
	@Override
	public boolean isCompatibleWithMoney() { 
		return true; 
	}
}
