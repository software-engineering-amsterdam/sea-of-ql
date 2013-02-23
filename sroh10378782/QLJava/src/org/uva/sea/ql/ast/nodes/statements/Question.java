package org.uva.sea.ql.ast.nodes.statements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.visitor.Visitor;

public class Question extends BinaryStatement<Expr, Statement> {
	public Question(Expr lhs,Statement rhs){
		super(lhs,rhs);
	}
	@Override
	public boolean isQuestionStatement(){
		return true;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}