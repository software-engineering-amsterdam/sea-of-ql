package org.uva.sea.ql.ast;

import java.util.ArrayList;
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
	public ArrayList<String> checkType(Map<Ident, Type> typeEnv) {
		ArrayList<String> retVal = new ArrayList<String>();
		Type type = typeOf(typeEnv);
		if(!(type.isCompatibleToStr()))
			retVal.add(type + " is not compatible. In " + this.getClass());
		return retVal;	
	}
}
