package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class:
 * @author Danny
 *
 * Mul: multiply
 */
public class Mul extends BinExpr {

	public Mul(Expr result, Expr rhs) {
		super(result, rhs, "*");
	}

}
