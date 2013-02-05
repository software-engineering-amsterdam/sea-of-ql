package org.uva.sea.ql.ast.elements;

import java.util.List;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.ASTElement;
import org.uva.sea.ql.common.ASTVisitor;
import org.uva.sea.ql.common.VisitorException;

public class IfStatement extends Expr implements ASTElement {
	private Expr condition;
	private Block content;

	public IfStatement(Expr cond, Block block) {
		this.condition = cond;
		this.content = block;
	}

	public final Expr getCondition() {
		return this.condition;
	}

	public final Block getContent() {
		return this.content;
	}

	@Override
	public final void accept(ASTVisitor visitor) throws VisitorException {
		visitor.visit(this);
	}

	public final List<Ident> getIdents() {
		return Ident.getIdents(this.condition);
	}

}
