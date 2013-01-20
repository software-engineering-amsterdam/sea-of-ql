package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: LEq
 * @author Danny
 *
 * LEq: <= (less then or equal)
 */
public class LEq extends BinExpr {

	public LEq(Expr result, Expr rhs) {
		super(result, rhs, "<=");
	}

}
