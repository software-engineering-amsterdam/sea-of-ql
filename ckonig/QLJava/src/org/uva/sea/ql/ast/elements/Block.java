package org.uva.sea.ql.ast.elements;

import java.util.List;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.ASTElement;
import org.uva.sea.ql.common.ElementVisitor;
import org.uva.sea.ql.common.QLException;

public class Block extends Expr implements ASTElement {
	private List<AbstractBlockElement> content;

	public Block(List<AbstractBlockElement> ex) {
		this.content = ex;
	}

	public final List<AbstractBlockElement> getContent() {
		return this.content;
	}

	public final void addLine(AbstractBlockElement e) {
		this.content.add(e);
	}

	@Override
	public final void accept(ElementVisitor visitor) throws QLException{
		visitor.visit(this);
	}
}
