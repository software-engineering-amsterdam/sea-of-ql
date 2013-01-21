package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.types.Type;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
		super.accept(visitor);
		return visitor.visit(this);
    }
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnvironment) {
		if (typeEnvironment.containsKey(this)) {
			return typeEnvironment.get(this);
			}
		return new ErrorType();
	}

}
