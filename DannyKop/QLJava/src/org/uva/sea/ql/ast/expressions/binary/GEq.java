package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: GEq
 * @author Danny
 *
 *GEq:  >= (greater then or equal)
 */
public class GEq extends BinExpr {

	public GEq(Expr result, Expr rhs) {
		super(result, rhs, ">=");
	}

}
