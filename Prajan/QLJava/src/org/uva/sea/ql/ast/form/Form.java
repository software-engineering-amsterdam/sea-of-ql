package org.uva.sea.ql.ast.form;

import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.FormElementVisitor;
import org.uva.sea.ql.visitor.IForm;

public class Form implements IForm {

	private final String formname;
	private Statements statements;

	public Statements getStatements() {
		return statements;
	}

	public void setStatements(Statements statements) {
		this.statements = statements;
	}

	public String getFormname() {
		return formname;
	}

	public Form(String formname) {
		this.formname = formname;

	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return null;
	}

	@Override
	public <T> T accept(FormElementVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
