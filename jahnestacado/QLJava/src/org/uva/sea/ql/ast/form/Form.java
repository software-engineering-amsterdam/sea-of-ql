package org.uva.sea.ql.ast.form;

import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.values.Ident;


public class Form implements ASTNode{
	private final Ident id;
	private final List<BodyElements> body;

	public Form(Ident id, List<BodyElements> body) {
			this.id=id;
			this.body=body;
			System.out.println("test form constructor");
	}

	public Ident getId() {
		return id;
	}

	public List<BodyElements> getBody() {
		return body;
	}

}
