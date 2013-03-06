package org.uva.sea.ql.ast.nodes.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.ast.nodes.expressions.composite.LeafExpression;
import org.uva.sea.ql.types.TInt;
import org.uva.sea.ql.types.Type;

public class Int extends LeafExpression {
	public Int(String value){
		super(value);
	}
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return null;
	}
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new TInt();
	}
}