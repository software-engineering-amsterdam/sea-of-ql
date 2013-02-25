package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.parser.TypeEnvironment;

public class Bool extends Value {

	private final boolean _value;
	
	public Bool(boolean value) {
		_value = value;
	}
	
	public boolean getValue() {
		return _value;
	}

	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		return new org.uva.sea.ql.ast.types.Bool();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}