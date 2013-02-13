package org.uva.sea.ql.ast.values;

import java.util.Map;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;
import org.uva.sea.ql.ast.types.BooleanType;

public class Bool extends Value{
	
	private final boolean value;
	
	public Bool( boolean value){
		this.value=value;
	}
	
	public boolean isValue() {
		return value;
	}
	
	@Override
	public <T> T accept(ICheckExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new BooleanType();
	}

}
