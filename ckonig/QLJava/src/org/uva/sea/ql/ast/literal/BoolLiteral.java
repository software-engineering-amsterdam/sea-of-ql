package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.expressions.Expr;

public class BoolLiteral extends Expr{
	private boolean value;
	public BoolLiteral(Boolean b) {
		this.value = b;
	}
	public final boolean getValue(){
		return this.value;
	}
}
