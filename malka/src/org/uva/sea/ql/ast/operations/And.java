package org.uva.sea.ql.ast.operations;

import org.uva.sea.ql.ast.Expr;

public class And extends BinaryOperation {

	public And(Expr left, Expr right) {
		super(left, right);
	}

}
