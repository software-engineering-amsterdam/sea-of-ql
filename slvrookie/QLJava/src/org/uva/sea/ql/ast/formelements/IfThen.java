package org.uva.sea.ql.ast.formelements;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitors.interfaces.IElementVisitor;

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
	public void accept(IElementVisitor ElementVisitor) {
		ElementVisitor.visit(this);
	}

}
