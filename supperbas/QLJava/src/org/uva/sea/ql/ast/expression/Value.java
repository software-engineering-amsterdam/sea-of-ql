package org.uva.sea.ql.ast.expression;

import java.util.HashSet;
import java.util.Set;

import org.uva.sea.ql.ast.Expression;


public abstract class Value extends Expression {

	public Value() {

	}

	public abstract String toString();

	public boolean isDefined() {
		return true;
	}

	public String getOperatorSymbol() {
		return null;
	}

	public Set<Ident> getIdents() {
		return new HashSet<Ident>();
	}

	public abstract Object getValue();

}
