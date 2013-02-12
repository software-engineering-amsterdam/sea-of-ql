package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;

public class VisibleComputetStat extends ComputedStat{

	public VisibleComputetStat(Ident ident, String label,Expr computableExpr ,Value initialValue) {
		super(ident, label,computableExpr,initialValue);
	}

}
