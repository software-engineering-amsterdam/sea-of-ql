package org.uva.sea.ql.ast.expr.primary;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.type.UndefinedType;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.typeCheck.TypeMapper;

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
	
	// Override "equals" and "hashCode" because we want 
	// to be able to identify Idents by name, not by ref
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
	public Type typeOf(TypeMapper typeMapper) {
		if (typeMapper.hasTypeKey(this)) {
			return typeMapper.getType(this);
		}
		return new UndefinedType();
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}