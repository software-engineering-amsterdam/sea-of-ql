package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.ast.expr.grouping.ValueExpr;
import org.uva.sea.ql.ast.expr.type.BoolType;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Bool extends ValueExpr {

	private Boolean value;
	private Type type = new BoolType();

	public Bool(int lineNumber) {
		super(lineNumber);
		this.value = false;
	}

	public Bool(int lineNumber, String initialValue) {
		super(lineNumber);
		this.value = new Boolean(initialValue);
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
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
