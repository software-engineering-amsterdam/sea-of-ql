package org.uva.sea.ql.ast.alg;

import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.AlgebricElementVisitor;
import org.uva.sea.ql.visitor.Value;

public class Str extends Value {

	private final String value;

	public String getValue() {
		return value;
	}

	public Str(String value) {
		this.value = value;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {

		return new StrType();
	}

	@Override
	public <T> T accept(AlgebricElementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return value;
	}

}
