package org.uva.sea.ql.ast.expr.value;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.message.Message;

public class Bool extends Expr {

	private final boolean value;
	
	public Bool(boolean value){
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public Value eval(Env env) {
		return new BoolVal(value);
	}

	@Override
	public Type typeOf(Env env) {
		return new BoolType();
	}

	@Override
	public List<Message> checkType(Env env) {
		return new ArrayList<Message>(); // Return an empty List. 
	}
}
