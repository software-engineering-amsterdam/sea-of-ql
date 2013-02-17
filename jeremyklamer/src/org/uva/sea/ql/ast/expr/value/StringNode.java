package org.uva.sea.ql.ast.expr.value;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.StringVal;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.message.Error;

public class StringNode extends Expr {

	private final String value;
	
	public StringNode(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public Value eval(Env env) {
		return new StringVal(value);
	}

	@Override
	public Type typeOf(Env env) {
		return new StringType();
	}

	@Override
	public List<Message> checkType(Env env) {
		ArrayList<Message> errors = new ArrayList<Message>();
		Type type = typeOf(env);
		if(!(type.isCompatibleToStr()))
			errors.add(new Error(type + " is not compatible. In " + this.getClass()));
		return errors;			
	}
}
