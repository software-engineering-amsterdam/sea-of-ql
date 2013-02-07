package org.uva.sea.ql.ast.ql;

import org.uva.sea.ql.ast.Block;
import org.uva.sea.ql.ast.cond.IfThen;
import org.uva.sea.ql.ast.expr.Expr;

public class SimpleConditionalQuestion extends IfThen implements ConditionalQuestion {

	public SimpleConditionalQuestion(Expr condition,
			Block<QLItem> statements) {
		super(condition, statements);
	}
}
