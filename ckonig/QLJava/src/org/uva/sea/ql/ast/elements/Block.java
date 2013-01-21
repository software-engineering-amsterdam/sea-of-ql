package org.uva.sea.ql.ast.elements;

import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.ASTElement;
import org.uva.sea.ql.visitor.ASTVisitor;

public class Block extends Expr implements ASTElement {
	private List<Expr> content;

	public Block(List<Expr> ex) {
		this.content = ex;
	}

	public List<Expr> getContent() {
		return content;
	}

	public void addLine(Expr e) {
		this.content.add(e);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}