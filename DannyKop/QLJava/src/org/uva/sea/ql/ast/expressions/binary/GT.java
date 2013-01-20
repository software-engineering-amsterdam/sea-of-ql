package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: GT
 * @author Danny
 *
 * GT: > (greater then)
 */
public class GT extends BinExpr {

	public GT(Expr result, Expr rhs) {
		super(result, rhs, ">");
	}

}
