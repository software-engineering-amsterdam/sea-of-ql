package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;

public class Div extends Binary {

	public Div(Expr result, Expr rhs) {
		super(result, rhs);
	}
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
		super.accept(visitor);
		return visitor.visit(this);
    }
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnvironment) {
		return new IntType();
	}

}
