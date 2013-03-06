package org.uva.sea.ql.ast;

import java.util.Map;
import java.util.Set;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Visitor;


public abstract class Expression implements ASTNode {

	public abstract <T> T accept(Visitor<T> visitor);
	public abstract Type typeOf(Map<Ident, Type> typeEnv);

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	public abstract String getOperatorSymbol();
	public abstract Set<Ident> getIdents();

}
