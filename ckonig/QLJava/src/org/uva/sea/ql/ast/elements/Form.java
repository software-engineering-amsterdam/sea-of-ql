package org.uva.sea.ql.ast.elements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.ASTElement;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.VisitorException;

public class Form extends Expr implements ASTElement {
	private Block content;
	private String name;

	public Form(String name, Block in) {
		this.name = name;
		this.content = in;
	}

	public String getName() {
		return name;
	}

	public Block getBlock() {
		return content;
	}

	@Override
	public void accept(ASTVisitor visitor) throws VisitorException{
		visitor.visit(this);
	}

}
