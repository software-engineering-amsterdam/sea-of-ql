package org.uva.sea.ql.ast.stmt;

import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.IFormVisitor;

public class IfThen extends Statement {
	private final Expr condition;
	private final List<Statement> ifBlock;

	public IfThen(Expr condition, List<Statement> ifBlock) {
		this.condition = condition;
		this.ifBlock = ifBlock;
	}

	public Expr getCondition() {
		return condition;
	}

	public List<Statement> getIfBlock() {
		return ifBlock;
	}

	@Override
	public void accept(IFormVisitor visitor) {
		visitor.visit(this);
	}
}