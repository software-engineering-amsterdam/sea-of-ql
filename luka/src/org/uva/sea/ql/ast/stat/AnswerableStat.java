package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.StatementVisitor;

public class AnswerableStat extends TypedStat {

	public AnswerableStat(Ident ident, String label, Type type) {
		super(ident, label,type);

	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	

}
