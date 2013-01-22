package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;

public class Not extends Binary {

	public Not(Expr x) {
		super(x);
	}
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
		super.accept(visitor);
		return visitor.visit(this);
    }
	
	@Override
	public Type typeOf(Map<String, Type> typeEnvironment) {
		return new BoolType();
	}

}
