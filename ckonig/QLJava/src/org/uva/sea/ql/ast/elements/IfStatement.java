package org.uva.sea.ql.ast.elements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.ASTElement;
import org.uva.sea.ql.visitor.ASTVisitor;

public class IfStatement extends Expr implements ASTElement {
	private Expr condition;
	private Block content;

	public IfStatement(Expr condition, Block content) {
		this.condition = condition;
		this.content = content;
	}

	public Expr getCondition() {
		return condition;
	}

	public Block getContent() {
		return content;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
