package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;

public abstract class ComputedStat extends TypedStat{

	public ComputedStat(Ident ident, String label, Expr computableExpr, Value initialVal) {
		super(ident, label, initialVal);
	}

	

}
