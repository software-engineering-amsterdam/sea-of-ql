package org.uva.sea.ql.ast.elements;

import java.util.List;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.visitor.ASTElement;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.VisitorException;

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
	public void accept(ASTVisitor visitor) throws VisitorException {
		visitor.visit(this);
	}

	public List<Ident> getIdents() {
		return Ident.getIdents(condition);
	}

}
