package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.StringVal;
import org.uva.sea.ql.interpreter.Value;

public class StringNode extends Expr {

	private final String value;
	
	public StringNode(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public Value interpret() {
		return new StringVal(value);
	}

	@Override
	public Type typeOf(Env env) {
		return new StringType();
	}

}
