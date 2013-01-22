package org.uva.sea.ql.ast.form;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Form extends ASTNode {
	private final Ident id;
	private final List<Element> body;

	public Form(Ident id, Body body) {
		this.id = id;
		this.body = body.getBody();

	}

	public Ident getId() {
		return id;
	}

	public List<Element> getBody() {
		return body;
	}

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);

	}

}
