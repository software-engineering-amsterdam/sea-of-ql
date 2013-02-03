package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: Eq
 * @author Danny
 * Eq: == (equal)
 */
public class Eq extends BinExpr {
	/**
	 * Constructor
	 * @param l left
	 * @param r right
	 */
	public Eq(Expr l, Expr r) {
		super(l, r, "==");
	}
	/**
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	@Override
	public boolean isCompatibleTo(Expr t) {
		return true;
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
	/**
	 * isCompatibleWithStr
	 * @return
	 */
	@Override
	public boolean isCompatibleWithStr() { 
		return true; 
	}
	/**
	 * isCompatibleWithBool
	 * @return
	 */
	public boolean isCompatibleWithBool() { 
		return true; 
	}
}
