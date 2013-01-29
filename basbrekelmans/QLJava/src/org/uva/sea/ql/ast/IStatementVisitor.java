package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.statements.*;

public interface IStatementVisitor {
	//statements
	void visit(Form element);
	void visit(If element);
	void visit(InputQuestion element);
	void visit(ComputedQuestion element);
	void visit(Statements element);
}