package org.uva.sea.ql.ast.nodes.values;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Int extends Value {

	private final int value;

	public Int(int val) {
		this.value = val;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new IntType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
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

	public int getValue() {
		return this.value;
	}

	@Override
	protected Value addInt(Int arg) {
		return new Int(arg.getValue() + getValue());
	}

	@Override
	protected Value subInt(Int arg) {
		return new Int(arg.getValue() - getValue());
	}

	@Override
	protected Value mulInt(Int arg) {
		return new Int(arg.getValue() * getValue());
	}

	@Override
	protected Value divInt(Int arg) {
		return new Int(arg.getValue() / getValue());
	}

}
