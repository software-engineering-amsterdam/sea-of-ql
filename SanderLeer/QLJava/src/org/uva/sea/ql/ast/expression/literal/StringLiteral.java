package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.Visitor;
import org.uva.sea.ql.ast.datatype.Datatype;
import org.uva.sea.ql.ast.datatype.StringType;
import org.uva.sea.ql.typechecker.SymbolTable;

public class StringLiteral extends Literals {
	private final String value;
	
	public StringLiteral(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Datatype typeOf(SymbolTable symbols) {
		return new StringType();
	}
}