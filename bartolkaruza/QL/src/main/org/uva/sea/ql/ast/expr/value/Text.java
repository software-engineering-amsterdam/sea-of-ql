package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.ast.expr.type.TextType;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Text extends Value {

	private static final long serialVersionUID = -2686137921702760938L;
	private String value;

	public Text(int lineNumber) {
		super(lineNumber);
		this.value = "";
	}

	public Text(int lineNumber, String initialValue) {
		super(lineNumber);
		this.value = initialValue;
	}
	
	@Override
	public String getRawValue() {
		return value;
	}

	@Override
	public void accept(ExpressionVisitor<?> visitor) {
		visitor.visit(this);
	}

	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return new TextType();
	}
	
	@Override
	public Value add(Value value) {
		return value.addString(this);
	}
	
	@Override
	public Value eq(Value value) {
		return value.eqString(this);
	}
	
	protected Text addString(Text value) {
		return new Text(getLineNumber(), value.getRawValue() + getRawValue());
	};
	
	@Override
	protected Bool eqString(Text value) {
		return new Bool(getLineNumber(), value.getRawValue().equals(getRawValue()));
	}

}
