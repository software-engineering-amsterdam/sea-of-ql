package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.ast.expr.grouping.ValueExpr;
import org.uva.sea.ql.ast.expr.type.TextStringType;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class TextString extends ValueExpr {

	private String value;
	private Type type = new TextStringType();

	public TextString(int lineNumber) {
		super(lineNumber);
		this.setValue("");
	}

	public TextString(int lineNumber, String initialValue) {
		super(lineNumber);
		this.value = initialValue;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
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
