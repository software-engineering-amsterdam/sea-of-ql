package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.StatementVisitor;

public class HiddenComputedStat extends ComputedStat {
	//statement is invisible computed
	public HiddenComputedStat(Ident ident, Expr computableExpr, Type type) {
		super(ident, "", type, computableExpr);
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String getLabel() {
		return "notSupported";
	}

	@Override
	public String toString() {
		return "HiddenComputetStat Ident(" + this.ident.toString() + ") Type("
				+ this.type.toString() + ")" + " Expr("
				+ this.getExpr().toString() + ")";
	}
}
