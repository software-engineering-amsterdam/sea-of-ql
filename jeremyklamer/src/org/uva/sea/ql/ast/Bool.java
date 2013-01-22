package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.Map;

import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.interpreter.BoolVal;

public class Bool extends Expr {

	private final boolean value;
	
	public Bool(boolean value){
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public Value interpret() {
		return new BoolVal(value);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new BoolType();
	}

	@Override
	public ArrayList<String> checkType(Map<Ident, Type> typeEnv) {
		return new ArrayList<String>(); // Return an empty List. 
	}
}
