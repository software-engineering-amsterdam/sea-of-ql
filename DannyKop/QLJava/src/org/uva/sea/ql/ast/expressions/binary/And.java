package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: And
 * @author Danny
 *
 */
public class And extends BinExpr {

	public And(Expr result, Expr rhs) {
		super(result, rhs, "&&");
	}

}
