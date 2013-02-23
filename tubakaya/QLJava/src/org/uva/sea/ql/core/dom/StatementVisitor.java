package org.uva.sea.ql.core.dom;

import org.uva.sea.ql.core.dom.statements.*;

public interface StatementVisitor {
	
	void visit(Form form);
	void visit(Question question);
	void visit(ComputedValue computedValue);
	void visit(IfStatement ifStatement);
}
