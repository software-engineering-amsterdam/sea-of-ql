package org.uva.sea.ql.ast.form;

import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.FormElementVisitor;
import org.uva.sea.ql.visitor.IForm;

public class Calculation extends IForm {

	private final String ident;

	private final Expr orexpr;

	public Calculation(String ident, Expr orexpr) {
		this.ident = ident;
		this.orexpr = orexpr;
		System.out.println(ident + "  Calculation");

	}

	public String getIdent() {
		return ident;
	}

	public Expr getOrexpr() {
		return orexpr;
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
