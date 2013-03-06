package org.uva.sea.ql.ast.nodes.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.ast.nodes.expressions.composite.LeafExpression;
import org.uva.sea.ql.types.TError;
import org.uva.sea.ql.types.Type;

public class Ident extends LeafExpression {
	public Ident(String value){
		super(value);
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		if(typeEnv.containsKey(this)){
			return typeEnv.get(this);
		} else {
			return new TError();
		}
	}

	@Override
	public int hashCode() {
		return this.getValue().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ident other = (Ident) obj;
		if (this.getValue() == null) {
			if (other.getValue() != null)
				return false;
		} else if (!this.getValue().equals(other.getValue()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " Ident : " + this.getValue();
	}
}
