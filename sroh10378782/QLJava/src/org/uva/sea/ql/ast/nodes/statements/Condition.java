package org.uva.sea.ql.ast.nodes.statements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.visitor.Visitable;
import org.uva.sea.ql.visitor.Visitor;

public class Condition extends UnaryStatement implements Visitable {
	public Condition(Expr x){
		super(x);
	}
	@Override
	public boolean isConditionStatement(){
		return true;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
