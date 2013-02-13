package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.StatementVisitor;

public class HiddenComputetStat extends ComputedStat{

	public HiddenComputetStat(Ident ident,Expr computableExpr , Type type) {
		super(ident, "",computableExpr, type);
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

}
