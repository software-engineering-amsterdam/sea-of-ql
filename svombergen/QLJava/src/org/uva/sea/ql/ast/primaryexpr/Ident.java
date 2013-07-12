package org.uva.sea.ql.ast.primaryexpr;

import org.uva.sea.ql.ast.statements.types.*;
import org.uva.sea.ql.gui.Environment;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Ident extends Str {
	private Type type;

	public Ident(String n) {
		this(n, null);
	}
	
	public Ident(String n, Type t) {
		super(n);
		setType(t);
	}
	
	public String getName() {
		return toString();
	}
	
	public void setType(Type t) {
		type = t;
	}
	
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public Type typeOf() {
		if (type == null)
			return null;
		else
			return type;
	}
	
	@Override
	public Type typeOf(Environment envir) {
		return envir.get(this).getType();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ident) {
			return value.equals(((Ident) obj).value);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

}
