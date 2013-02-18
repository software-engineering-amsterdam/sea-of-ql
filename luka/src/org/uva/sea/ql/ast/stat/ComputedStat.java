package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;

public abstract class ComputedStat extends TypedStat {

	private Expr expression;

	public ComputedStat(Ident ident, String label, Type type,
			Expr computableExpr) {
		super(ident, label, type);
		this.expression = computableExpr;
	}

	public Expr getExpr() {
		return this.expression;
	}

}
