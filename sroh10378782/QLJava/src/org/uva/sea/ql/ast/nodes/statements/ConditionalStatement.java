package org.uva.sea.ql.ast.nodes.statements;

import org.uva.sea.ql.visitor.Visitable;
import org.uva.sea.ql.visitor.Visitor;

public class ConditionalStatement extends BinaryStatement<Statement,Statement> implements Visitable {
	public ConditionalStatement(Statement lhs, Statement rhs) {
		super(lhs, rhs);
	}
	@Override
	public boolean isConditionalStatement(){
		return true;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
