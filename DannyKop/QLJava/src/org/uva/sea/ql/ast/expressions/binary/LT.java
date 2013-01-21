package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: LT
 * @author Danny
 * 
 * LT: < (less then)
 */
public class LT extends BinExpr {

	public LT(Expr result, Expr rhs) {
		super(result, rhs, "<");
	}

}
