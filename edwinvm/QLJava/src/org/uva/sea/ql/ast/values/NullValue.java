package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.types.Error;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.check.TypeEnvironment;

public class NullValue extends Value {
	@Override
	public NullValue getValue() {
		return null;
	}
	
	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		return new Error();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}