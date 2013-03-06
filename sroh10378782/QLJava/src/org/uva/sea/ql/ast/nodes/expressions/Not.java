package org.uva.sea.ql.ast.nodes.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.ast.nodes.expressions.composite.UnaryExpression;
import org.uva.sea.ql.types.TBool;
import org.uva.sea.ql.types.Type;


public class Not extends UnaryExpression {
	public Not(Expr x){
		super(x);
	}
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new TBool();
	}
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
