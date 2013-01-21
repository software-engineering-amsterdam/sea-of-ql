package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
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
	public Type typeOf(Env env) {
		if(env.getVars().containsKey(value)){
			return env.getVars().get(value);
		}
		else{
			//TODO return error
			return null;
		}
		
	}
	
}
