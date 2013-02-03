package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.*;


/**
 * Class: And
 * @author Danny
 *
 */
public class And extends BinExpr {

	/**
	 * Constructor
	 * @param l left
	 * @param r right
	 */
	public And(Expr l, Expr r) {
		super(l, r, "&&");
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
	@Override
	public boolean isCompatibleWithBool() { 
		return true; 
	}
}
