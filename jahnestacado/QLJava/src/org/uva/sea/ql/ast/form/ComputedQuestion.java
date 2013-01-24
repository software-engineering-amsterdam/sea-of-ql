package org.uva.sea.ql.ast.form;


import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.StringLit;

public class ComputedQuestion extends Element {
	private final Ident id;
	private final StringLit label;
	private final Type type;
	private final Expr expr;

	public ComputedQuestion(Ident id, StringLit label, Type type, Expr expr) {
			this.id=id;
			this.label=label;
			this.type=type;
			this.expr=expr;
	}

	public Ident getId() {
		return id;
	}

	public StringLit getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}

	public Expr getExpr() {
		return expr;
	}

	

}
