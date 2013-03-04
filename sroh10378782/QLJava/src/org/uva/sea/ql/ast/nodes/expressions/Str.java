package org.uva.sea.ql.ast.nodes.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.types.TStr;
import org.uva.sea.ql.types.Type;

public class Str extends Expr {
	private final String value;
	public Str(String val){
		this.value = val;
	}
	public String getValue(){
		return this.value;
	}
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new TStr();
	}
}
