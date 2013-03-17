package org.uva.sea.ql.ast.form;

import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.FormElementVisitor;

public class Declaration extends ObservableStatement {

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
