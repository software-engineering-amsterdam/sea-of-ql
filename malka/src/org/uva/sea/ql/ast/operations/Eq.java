package org.uva.sea.ql.ast.operations;

import org.uva.sea.ql.ast.Expr;

public class Eq extends BinaryOperation {

	public Eq(Expr left, Expr right) {
		super(left, right);
	}

}
