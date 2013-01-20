package org.uva.sea.ql.ast.operations;

import org.uva.sea.ql.ast.Expr;

public class Or extends BinaryOperation {

	public Or(Expr left, Expr right) {
		super(left, right);
	}

}
