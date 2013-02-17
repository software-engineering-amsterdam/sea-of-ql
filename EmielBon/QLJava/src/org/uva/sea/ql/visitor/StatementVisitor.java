package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.*;

public interface StatementVisitor<T> {

	T visit(Statements stat);
	T visit(ComputedQuestion stat);
	T visit(IfBlock stat);
	T visit(Question stat);
	
}
