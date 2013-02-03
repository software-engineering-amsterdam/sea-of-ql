package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExprVisitor;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		if (typeEnv.containsKey(this.getName())) {
			return typeEnv.get(this.getName());
		}
		return new ErrorType();
	}

	/*
	 * ErrorType prevents null pointer exceptions by allowing the ExprVisitor
	 * class to handle the case of an undeclared variable.
	 */

	@Override
	public <T> T accept(IExprVisitor<T> ExprVisitor) {
		return ExprVisitor.visit(this);
	}

}
