package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.Visitor;
import org.uva.sea.ql.ast.datatype.BooleanType;
import org.uva.sea.ql.ast.datatype.Datatype;
import org.uva.sea.ql.typechecker.SymbolTable;

public class BooleanLiteral extends Literals {
	private final boolean value;
	
	public BooleanLiteral(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Datatype typeOf(SymbolTable symbols) {
		return new BooleanType();
	}
}
