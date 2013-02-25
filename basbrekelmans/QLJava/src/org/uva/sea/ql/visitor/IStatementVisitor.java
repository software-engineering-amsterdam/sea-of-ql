package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statements.*;

public interface IStatementVisitor {
	void visit(If element);

	void visit(IfElse element);

	void visit(InputQuestion element);

	void visit(ComputedQuestion element);

	void visit(Statements element);
}