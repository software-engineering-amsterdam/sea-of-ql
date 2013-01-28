package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.interpreter.StringVal;

public class Ident extends Expr {

	private final String value;

	public Ident(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	@Override
	public Value interpret() {
		return new StringVal(getValue());
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		if(typeEnv.containsKey(this)){
			return typeEnv.get(this);
		}
		else{
			//TODO return error
			return null;
		}
		
	}

	@Override
	public ArrayList<String> checkType(Map<Ident, Type> typeEnv) {
		return new ArrayList<String>();
	}
	
}
