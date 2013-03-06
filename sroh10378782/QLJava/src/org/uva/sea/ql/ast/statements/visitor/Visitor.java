package org.uva.sea.ql.ast.statements.visitor;

import org.uva.sea.ql.ast.nodes.statements.*;

public interface Visitor {
	void visit(Form form);
	void visit(Block block);
	void visit(Question question);
	void visit(ComputedQuestion computedQuestion);
	void visit(IfThen ifThen);
	void visit(IfThenElse ifThenElse);
}