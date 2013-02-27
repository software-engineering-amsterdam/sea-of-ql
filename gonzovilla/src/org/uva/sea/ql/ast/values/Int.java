package org.uva.sea.ql.ast.values;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.TypeInt;
import org.uva.sea.ql.ast.visitor.VisitorExpressions;

public class Int extends Value {

	private final int value;

	public Int(int value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		return new TypeInt();
	}

	@Override
	public <T> T accept(VisitorExpressions<T> visitor) {
		return  visitor.visit(this);
	}
	
	@Override
	public Value add(Value value) {
		return value.addInt(this);
	}

	@Override
	protected Value addInt(Int value) {
		return new Int(value.getValue() + this.value);
	}

	@Override
	public Value sub(Value value) {
		return value.subInt(this);
	}

	@Override
	protected Value subInt(Int value) {
		return new Int(value.getValue() - this.value);
	}

	@Override
	public Value div(Value value) {
		return value.divInt(this);
	}

	@Override
	protected Value divInt(Int value) {
		return new Int(value.getValue() / this.value);
	}

	@Override
	public Value mul(Value value) {
		return value.mulInt(this);
	}

	@Override
	protected Value mulInt(Int value) {
		return new Int(value.getValue() * this.value);
	}

	@Override
	public Value leq(Value value) {
		return value.leqInt(this);
	}

	@Override
	protected Value leqInt(Int value) {
		return new BoolValue(value.getValue() <= this.value);
	}

	@Override
	public Value lt(Value value) {
		return value.ltInt(this);
	}

	@Override
	protected Value ltInt(Int value) {
		return new BoolValue(value.getValue() < this.value);
	}

	@Override
	public Value geq(Value value) {
		return value.geqInt(this);
	}

	@Override
	protected Value geqInt(Int value) {
		return new BoolValue(value.getValue() >= this.value);
	}

	@Override
	public Value gt(Value value) {
		return value.gtInt(this);
	}

	@Override
	protected Value gtInt(Int value) {
		return new BoolValue(value.getValue() > this.value);
	}

	@Override
	public Value neg() {
		return new Int(-(getValue()));
	}

	@Override
	public Value pos() {
		return new Int(+(getValue()));
	}

}
