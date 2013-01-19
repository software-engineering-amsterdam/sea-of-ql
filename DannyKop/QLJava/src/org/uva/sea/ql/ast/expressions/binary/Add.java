package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: Add
 * @author Danny
 */
public class Add extends BinExpr {

	public Add(Expr result, Expr rhs) {
		super(result, rhs, "+");
	}

}
