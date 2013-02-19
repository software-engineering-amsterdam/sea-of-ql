package org.uva.sea.ql.ast.nodes.statements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.visitor.Visitor;

public class Form extends BinaryStatement<Expr, Statement> {
	public Form(Expr lhs, Statement rhs){
		super(lhs,rhs);
	}
	@Override
	public boolean isFormStatement(){
		return true;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
