package org.uva.sea.ql.ast.expressions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.messages.Message;

public class Int extends Expr {

	private final int value;

	public Int(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public Value eval(Env environment) {
		return new org.uva.sea.ql.ast.values.IntValue(value);
	}

	@Override
	public Type typeOf(Env environment) {
		return new org.uva.sea.ql.ast.types.IntType();
	}
	
	@Override
	public List<Message> checkType(Env environment) {
		List<Message> errors = new ArrayList<Message>();
		return errors;
	}
	
	@Override
	public String toString() {
		return Integer.toString(value);
	}

	@Override
	public Set<Type> allowedArgumentTypes() {
		return new HashSet<Type>();
	}
}
