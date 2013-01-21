package org.uva.sea.ql.ast.form;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.visitor.ASTNodeVisitor;


public class Form extends ASTNode{
	private final Ident id;
	private final List<Element> body= new ArrayList<Element>();

	public Form(Ident id, Body body) {
			this.id=id;
			this.body.addAll(body.getBody());
			
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
