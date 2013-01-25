package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.antlr.runtime.Token;
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
		if (typeEnv.containsKey(this.getName()) ) {
			return typeEnv.get(this.getName()) ;
			}
			return new ErrorType();
			//should throw error
	}

	@Override
	public <T> T accept(IExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
