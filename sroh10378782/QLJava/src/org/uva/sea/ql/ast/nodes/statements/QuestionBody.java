package org.uva.sea.ql.ast.nodes.statements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.visitor.Visitor;

public class QuestionBody extends BinaryStatement<Expr,Expr> {
	public QuestionBody(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	@Override
	public boolean isQuestionBodyStatement(){
		return true;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
