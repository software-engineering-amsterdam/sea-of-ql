package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: Div
 * @author Danny
 *
 */
public class Div extends BinExpr {

	public Div(Expr result, Expr rhs) {
		super(result, rhs, "/");
	}

}
