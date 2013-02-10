package org.uva.sea.ql.ast.expr.primary;

import org.uva.sea.ql.type.IntegerType;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.SymbolTable;


public class Int extends Primary<Integer> {

	private final int value;

	public Int(int value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "Int";
	}

	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return new IntegerType();
	}
	
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
