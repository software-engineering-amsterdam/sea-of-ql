package org.uva.sea.ql.ast.ql;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.StringValue;
import org.uva.sea.ql.ast.type.Type;

public class ComputedQuestion extends Question {

	private final Expr expr;
	
	public ComputedQuestion(Ident id, StringValue label, Type type, Expr expr) {
		super(id, label, type);
		this.expr = expr;
	}
	
	public Expr getExpr() {
		return expr;
	}
	
}
