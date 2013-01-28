package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
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
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new StringType();
	}

	@Override
	public List<Error> checkType(Map<Ident, Type> typeEnv) {
		ArrayList<Error> errors = new ArrayList<Error>();
		Type type = typeOf(typeEnv);
		if(!(type.isCompatibleToStr()))
			errors.add(new Error(type + " is not compatible. In " + this.getClass()));
		return errors;			
	}
}
