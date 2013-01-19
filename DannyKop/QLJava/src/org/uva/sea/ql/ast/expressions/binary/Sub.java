package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: Sub
 * @author Danny
 *
 * Sub: - (subtract)
 */
public class Sub extends BinExpr {

	/**
	 * Constructor
	 * @param result
	 * @param rhs
	 */
	public Sub(Expr result, Expr rhs) {
		super(result, rhs, "-");
	}

}
