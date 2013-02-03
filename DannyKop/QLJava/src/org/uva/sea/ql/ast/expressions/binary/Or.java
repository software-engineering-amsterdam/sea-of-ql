package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: Or
 * @author Danny
 *
 */
public class Or extends BinExpr {
	/**
	 * Constructor
	 * @param l left
	 * @param r right
	 */
	public Or(Expr l, Expr r) {
		super(l, r, "||");
	}
	/**
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	@Override
	public boolean isCompatibleTo(Expr t) {
		return t.isCompatibleWithBool();
	}
	/**
	 * isCompatibleWithBool
	 * @return
	 */
	public boolean isCompatibleWithBool() { 
		return true; 
	}
}
