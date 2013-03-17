package org.uva.sea.ql.ast.alg;

import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.AlgebricElementVisitor;
import org.uva.sea.ql.visitor.Value;

public class Bool extends Value {

	private final boolean value;

	public Bool(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new IntType();
	}

	@Override
	public <T> T accept(AlgebricElementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Value equals(Value arg) {
		return arg.equalsBool(this);
	}

	@Override
	public Value equalsBool(Bool arg) {
		return new Bool(arg.getValue() == getValue());
	}

	@Override
	public String toString() {
		return Boolean.toString(value);
	}

}
