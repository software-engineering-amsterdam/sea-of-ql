package org.uva.sea.ql.ast.nodes.values;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Str extends Value {

	private final String value;

	public Str(String val) {
		this.value = val;
	}

	public String getValue(){
		return this.value;
	}
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new StringType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Str("+this.value+")";
	}
//	@Override
//	public Type typeOf(Map<Ident, Type> typeEnv) {
//		return new StringType();
//	}
//
//	@Override
//	public <T> T accept(Visitor<T> visitor) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
