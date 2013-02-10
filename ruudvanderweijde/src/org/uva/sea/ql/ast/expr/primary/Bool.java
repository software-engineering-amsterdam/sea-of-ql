package org.uva.sea.ql.ast.expr.primary;

import org.uva.sea.ql.type.BooleanType;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.SymbolTable;


public class Bool extends Primary<Boolean> {
	private final boolean value;

	public Bool(boolean value) {
		this.value = value;
	}
	
	public Boolean getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "Bool";
	}

	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return new BooleanType();
	}


	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
