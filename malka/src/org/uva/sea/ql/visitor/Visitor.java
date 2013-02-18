package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expression.Expression;

public interface Visitor {
	
	void visit(Expression expression);
	
}
