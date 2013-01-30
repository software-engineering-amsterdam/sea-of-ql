package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.TypeChecker;

public class IfThenElse extends IfThen {

	private final Block elseBody;

	public IfThenElse(Expr condition, Block thenBody, Block elseBody) {
		super(condition, thenBody);
		this.elseBody = elseBody;
	}

	public Block getElseBody() {
		return elseBody;
	}

	@Override
	public void accept(TypeChecker visitor) {
		visitor.visit(this);
	}
	
}
