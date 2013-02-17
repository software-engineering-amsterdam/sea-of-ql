package org.uva.sea.ql.ast.expr.value;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.message.Message;

public class Int extends Expr {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	@Override
	public Value eval(Env env) {
		return new org.uva.sea.ql.interpreter.IntVal(this.value);
	}
	
	@Override
	public Type typeOf(Env env) {
		return new IntType();
	}
	
	@Override
	public List<Message> checkType(Env env) {
		return new ArrayList<Message>();
	}
	
}
