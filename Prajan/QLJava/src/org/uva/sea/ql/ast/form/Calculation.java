package org.uva.sea.ql.ast.form;

import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.FormElementVisitor;
import org.uva.sea.ql.visitor.IForm;

public class Calculation extends ObservableStatement implements IForm {

	private final Ident ident;

	private final Expr orexpr;

	public Calculation(String ident, Expr orexpr) {
		this.ident = new Ident(ident);
		this.orexpr = orexpr;

	}

	public Ident getIdent() {
		return ident;
	}

	public Expr getOrexpr() {
		return orexpr;
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
