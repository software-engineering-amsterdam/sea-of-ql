package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: Not
 * @author Danny
 * 
 */
public class Not extends UnaryExpr {

	public Not(Expr expr) {
		super(expr, "!");
	}

}
