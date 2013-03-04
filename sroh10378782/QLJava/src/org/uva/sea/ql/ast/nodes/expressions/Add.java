package org.uva.sea.ql.ast.nodes.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.ast.nodes.expressions.composite.BinaryExpression;
import org.uva.sea.ql.types.TNumeric;
import org.uva.sea.ql.types.Type;

public class Add extends BinaryExpression{
	public Add(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	@Override
	public Type typeOf(Map<org.uva.sea.ql.ast.nodes.expressions.Ident, Type> typeEnv) {
		return new TNumeric();
	}
}