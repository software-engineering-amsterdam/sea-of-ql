package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.StatementVisitor;

public class AnswerableStat extends TypedStat{
	//User is responsible for providing value
	//DEFAULT value for Value
	
	public AnswerableStat(Ident ident, String label, Type type) {
		super(ident, label, type);
		
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}



	

}
