package org.uva.sea.ql.ast.nodes.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.ast.nodes.expressions.composite.LeafExpression;
import org.uva.sea.ql.types.TNumeric;
import org.uva.sea.ql.types.Type;

public class Money extends LeafExpression {
	public Money(String value){
		super(value);
	}
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new TNumeric();
	}
}
