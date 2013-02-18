package org.uva.sea.ql.typechecker;

import org.uva.sea.ql.ast.statement.*;

public interface StatementVisitor<T> {

	T visit(ComputedQuestion stat);
	T visit(Question stat);
	T visit(IfBlock stat);
	T visit(Form stat);
	T visit(Statements stat);
	
}
