package org.uva.sea.ql.ast.expr.primary;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.type.UndefinedType;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.SymbolTable;


public final class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Ident";
	}
	
	// Implemented "equals" and "hashCode" to be able to compare objects with the same string
	// If object are they same, but have different references, they will not be found in the hashmap.
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ident) {
			return name.equals(((Ident) obj).name);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public Type typeOf(SymbolTable symbolTable) {
		if (symbolTable.hasTypeKey(this)) {
			return symbolTable.getType(this);
		}
		return new UndefinedType();
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
