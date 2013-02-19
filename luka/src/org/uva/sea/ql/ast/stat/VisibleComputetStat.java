package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.StatementVisitor;

public class VisibleComputetStat extends ComputedStat {
	//base class for visible statements
	public VisibleComputetStat(Ident ident, String label, Expr computableExpr,
			Type type) {
		super(ident, label, type, computableExpr);
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "VisibleComputetStat Ident(" + this.ident.toString() + ") Type("
				+ this.type.toString() + ") Label(" + this.label + ")";
	}
}
