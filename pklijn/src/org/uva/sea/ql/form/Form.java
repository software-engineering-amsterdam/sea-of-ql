package org.uva.sea.ql.form;

import java.util.List;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;

public class Form {

	private Ident id;
	private List<FormItem> body;
	
	public Form(Ident id, List<FormItem> formItems) {
		this.id = id;
		this.body = formItems;
	}

	public Ident getIdentity() {
		return id;
	}
	
	public List<FormItem> getBody() {
		return body;
	}

	public void print() {
		System.out.println("formItems: " + id.getName());
		for (FormItem f : body) {
			f.print(0);
		}		
	}
	
	public boolean checkFormValidity() {
		boolean valid = true;
		Env environment = new Env();
		for (FormItem f : body) {
			if (!f.validate(environment))
				valid = false;
		}
		return valid;
	}
}
