package org.uva.sea.ql.ast.values;

import java.util.Map;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;
import org.uva.sea.ql.ast.types.BooleanType;

public class Bool extends Value{
	
	private final Boolean value;
	
	public Bool( boolean value){
		this.value=value;
	}
	
	public boolean getValue() {
		return value;
	}
	
	public <T> T accept(ICheckExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new BooleanType();
	}
	
	@Override
	public Value and(Value arg) {
		return arg.andBool(this);
		}
	
	@Override
	public Value andBool(Bool arg) {
		return new Bool(arg.getValue() && getValue());
	}
	
	@Override
	public Value eq(Value arg) {
		return arg.eqBool(this);
	}
	
	@Override
	public Value eqBool(Bool arg) {
		return new Bool(arg.getValue() == getValue());
	}
	
	@Override
	public Value neq(Value arg) {
		return arg.neqBool(this);
	}

	@Override
	public Value neqBool(Bool arg) {
		return new Bool(arg.getValue() != getValue());
	}
	
	@Override
	public Value not() {
		return new Bool(!getValue());
	}
	
	@Override
	public Value or(Value arg) {
		return arg.orBool(this);
	}

	@Override
	public Value orBool(Bool arg) {
		return new Bool(arg.getValue() || getValue());
	}

	
	
}
