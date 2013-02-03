package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.*;

/**
 * Class: Add
 * @author Danny
 */
public class Add extends BinExpr {

	/**
	 * Constructor
	 * @param result
	 * @param rhs
	 */
	public Add(Expr l, Expr r) {
		super(l, r, "+");
	}
	/**
	 * isCompatibleTo
	 * @param t - check if this element is compatible with element of type t
	 * @return true if this element type is compatible with element type of t, false otherwise
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
	/**
	 * accept
	 * @param visitor
	 */
	public void accept(Visitor visitor){
		visitor.visit(this);
	}
}
