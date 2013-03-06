package org.uva.sea.ql.ast.expression;

import java.util.HashSet;
import java.util.Set;

import org.uva.sea.ql.ast.Expression;



public abstract class Unary extends Expression {
	
	private final Expression expression;

	public Unary(Expression expression) {
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}
	
	public Set<Ident> getIdents(){
		Set<Ident> idents = new HashSet<Ident>();
		idents.addAll(expression.getIdents());
		return idents;		
	}

}
