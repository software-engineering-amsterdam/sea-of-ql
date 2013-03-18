package org.uva.sea.ql.ast.alg;

import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.AlgebricElementVisitor;
import org.uva.sea.ql.visitor.Value;

public class Int extends Value {

	private final int value;

	public Int(int value) {
		this.value = value;
	}

	public int getValue() {
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
	public Value add(Value arg) {
		return arg.addInt(this);
	}

	@Override
	public Value sub(Value arg) {
		return arg.subInt(this);
	}

	@Override
	public Value div(Value arg) {
		return arg.divInt(this);
	}

	@Override
	public Value mul(Value arg) {
		return arg.mulInt(this);
	}

	@Override
	public Value addInt(Int arg) {
		return new Int(arg.getValue() + getValue());
	}

	@Override
	public Value subInt(Int arg) {
		return new Int(arg.getValue() - getValue());
	}

	@Override
	public Value mulInt(Int arg) {
		return new Int(arg.getValue() * getValue());
	}

	@Override
	public Value divInt(Int arg) {
		return new Int(arg.getValue() / getValue());
	}

	@Override
	public Value equals(Value arg) {
		return arg.equalsInt(this);
	}

	@Override
	public Value equalsInt(Int arg) {
		return new Bool(arg.getValue() == getValue());
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}

}
