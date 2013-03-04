package org.uva.sea.ql.ast.nodes.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitable;
import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.ast.nodes.expressions.composite.BinaryExpression;
import org.uva.sea.ql.types.TNumeric;
import org.uva.sea.ql.types.Type;


public class Div extends BinaryExpression implements Visitable {
	public Div(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new TNumeric();
	}
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}