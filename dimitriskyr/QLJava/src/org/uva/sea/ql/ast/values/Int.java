package org.uva.sea.ql.ast.values;

import java.util.Map;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;

public class Int extends Value {
	private final int value;
	
	public Int (int value){
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
	
	public <T> T accept(ICheckExprVisitor <T> visitor) {
		return visitor.visit(this);
	}

	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new IntegerType();
	}
	
	@Override
	public Value add(Value arg) {
		return arg.addInt(this);
	}

	@Override
	public Value addInt(Int value) {
		return new Int(value.getValue() + getValue());
	}
	
	@Override
	public Value div(Value arg) {
		return arg.divInt(this);
	}

	@Override
	public Value divInt(Int arg) {
		return new Int(arg.getValue() / getValue());
	}
	
	@Override
	public Value eq(Value arg) {
		return arg.eqInt(this);
	}

	@Override
	public Value eqInt(Int arg) {
		return new Bool(arg.getValue() == getValue());
	}
	
	@Override
	public Value geq(Value arg) {
		return arg.geqInt(this);
	}

	@Override
	public Value geqInt(Int arg) {
		return new Bool(arg.getValue() >= getValue());
	}
	
	@Override
	public Value gt(Value arg) {
		return arg.gtInt(this);
	}

	@Override
	public Value gtInt(Int arg) {
		return new Bool(arg.getValue() > getValue());
	}
	
	@Override
	public Value leq(Value arg) {
		return arg.leqInt(this);
	}

	@Override
	public Value leqInt(Int arg) {
		return new Bool(arg.getValue() <= getValue());
	}
	
	@Override
	public Value lt(Value arg) {
		return arg.ltInt(this);
	}

	@Override
	public Value ltInt(Int arg) {
		return new Bool(arg.getValue() < getValue());
	}
	
	@Override
	public Value mul(Value arg) {
		return arg.mulInt(this);
	}

	@Override
	public Value mulInt(Int arg) {
		return new Int(arg.getValue() * getValue());
	}
	
	@Override
	public Value neg() {
		return new Int(-this.value);
	}
	
	@Override
	public Value neq(Value arg) {
		return arg.neqInt(this);
	}

	@Override
	public Value neqInt(Int arg) {
		return new Bool(arg.getValue() != getValue());
	}
	
	@Override
	public Value pos() {
		return new Int(+this.value);
	}

	@Override
	public Value sub(Value arg) {
		return arg.subInt(this);
	}

	@Override
	public Value subInt(Int arg) {
		return new Int(arg.getValue() - getValue());
	}
} 
