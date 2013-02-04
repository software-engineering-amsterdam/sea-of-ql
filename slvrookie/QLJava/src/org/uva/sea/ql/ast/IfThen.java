package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.ITypeChecker;

public class IfThen extends FormElement {

	private final Expr condition;
	private final Block thenBody;

	public IfThen(Expr condition, Block thenBody) {
		this.condition = condition;
		this.thenBody = thenBody;
	}

	public Expr getCondition() {
		return condition;
	}

	public Block getThenBody() {
		return thenBody;
	}

	@Override
	public void accept(ITypeChecker TypeChecker) {
		TypeChecker.visit(this);
	}

}
