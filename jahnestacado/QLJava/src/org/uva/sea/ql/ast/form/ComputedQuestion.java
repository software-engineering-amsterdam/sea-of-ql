package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Ident;

public class ComputedQuestion extends BodyElements implements ASTNode {
	private final Ident id;
	private final String label;
	private final Type type;
	private final Expr expr;

	public ComputedQuestion(Ident id, String label, Type type, Expr expr) {
			this.id=id;
			this.label=label;
			this.type=type;
			this.expr=expr;
	}

	public Ident getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}

	public Expr getExpr() {
		return expr;
	}

}
