package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.types.Error;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.parser.TypeEnvironment;

public class Identifier extends Expression {

	private final String _value;
	
	public Identifier(String value) {
		_value = value;
	}
	
	public String getValue() {
		return _value;
	}
	
	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		if (typeEnvironment.contains(this)) {
			return typeEnvironment.get(this);
		}
		return new Error();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_value == null) ? 0 : _value.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		Identifier identifier = (Identifier) obj;
		return ((String)this.getValue()).equals(((String)identifier.getValue()));
	}
	
}