package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: NEq
 * @author Danny
 *
 * NEq: != (not equal)
 */
public class NEq extends BinExpr {

	public NEq(Expr result, Expr rhs) {
		super(result, rhs, "!=");
	}

}
