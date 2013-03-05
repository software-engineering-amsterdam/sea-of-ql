package org.uva.sea.ql.ast.form;

import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.FormElementVisitor;
import org.uva.sea.ql.visitor.IForm;

public class Declaration extends IForm {

	private final Ident ident;

	private final Type identtype;

	public Ident getIdent() {
		return ident;
	}

	public Type getIdenttype() {
		return identtype;
	}

	public Declaration(Ident ident, Type identtype) {

		this.ident = ident;
		this.identtype = identtype;

		System.out.println(ident + "  " + identtype + "     Declaration ");
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T accept(FormElementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
