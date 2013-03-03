package org.uva.sea.ql.ast.expression.value;

import java.util.Map;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Value;
import org.uva.sea.ql.ast.expression.Visitor;


public class Str extends Value {

	private final String value;

	public Str(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return this.value;
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.type.Str();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
