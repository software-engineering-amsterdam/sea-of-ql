package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.Visitor;
import org.uva.sea.ql.ast.datatype.Datatype;
import org.uva.sea.ql.ast.datatype.IntegerType;
import org.uva.sea.ql.typechecker.SymbolTable;

public class IntegerLiteral extends Literals {
	private final int value;

	public IntegerLiteral(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Datatype typeOf(SymbolTable symbols) {
		return new IntegerType();
	}
}
