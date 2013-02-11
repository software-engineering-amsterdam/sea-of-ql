package org.uva.sea.ql.ast.values;

import java.util.Map;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;

public class Int extends Value {
	private final int value;
	
	public Int (int value){
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public <T> T accept(ICheckExprVisitor <T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new IntegerType();
	}
}
