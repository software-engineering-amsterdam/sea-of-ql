package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Visitor;
import org.uva.sea.ql.ast.datatype.Datatype;
import org.uva.sea.ql.typechecker.SymbolTable;

public class Identifier extends Expression {
	private final String name;

	public Identifier(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Datatype typeOf(SymbolTable symbols) {
		if (symbols.contains(this.getName())) {
			return symbols.get(this.getName());
		}
		return null;
	}
}
