package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: Neg
 * @author Danny
 *
 * Neg: negative
 */
public class Neg extends UnaryExpr {

	public Neg(Expr expr) {
		super(expr, "-");
	}

}
