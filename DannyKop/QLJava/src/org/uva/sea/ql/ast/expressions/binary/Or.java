package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: Or
 * @author Danny
 *
 */
public class Or extends BinExpr {

	public Or(Expr result, Expr rhs) {
		super(result, rhs, "||");
	}

}
