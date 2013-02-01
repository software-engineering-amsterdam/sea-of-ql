package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.ast.expr.grouping.ValueExpr;
import org.uva.sea.ql.ast.expr.type.IntType;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Int extends ValueExpr {

	private final int value;
	private Type type = new IntType();

	public Int(int lineNumber) {
		super(lineNumber);
		value = 0;
	}

	public Int(int lineNumber, String value) {
		super(lineNumber);
		this.value = Integer.parseInt(value);
	}

	public int getValue() {
		return value;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return type;
	}

}
