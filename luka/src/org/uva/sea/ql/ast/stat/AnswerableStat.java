package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;

public class AnswerableStat extends TypedStat{
	//User is responsible for providing value
	public AnswerableStat(Ident ident, String label, Value value) {
		super(ident, label, value);
		
	}

	

}
