package org.uva.sea.ql.ast.expression;

import java.util.HashSet;
import java.util.Set;

import org.uva.sea.ql.ast.Expression;



public abstract class Binary extends Expression {
	
	private final Expression lhs;
	private final Expression rhs;

	public Binary(Expression lhs, Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expression getRhs() {
		return rhs;
	}

	public Expression getLhs() {
		return lhs;
	}
	
	public Set<Ident> getIdents(){
		Set<Ident> idents = new HashSet<Ident>();
		idents.addAll(lhs.getIdents());
		idents.addAll(rhs.getIdents());
		return idents;		
	}

}
