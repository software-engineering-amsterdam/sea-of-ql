package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;

public class HiddenComputetStat extends ComputedStat{

	public HiddenComputetStat(Ident ident,Expr computableExpr , Value initialValue) {
		super(ident, "",computableExpr, initialValue);
	}

}
