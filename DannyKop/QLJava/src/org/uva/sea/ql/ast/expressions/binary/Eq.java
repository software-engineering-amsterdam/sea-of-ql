package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: Eq
 * @author Danny
 * Eq: == (equal)
 */
public class Eq extends BinExpr {

	public Eq(Expr result, Expr rhs) {
		super(result, rhs, "==");
	}

}
