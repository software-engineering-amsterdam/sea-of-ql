package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;

public class BooleanLiteral extends Expr {
	
	private final boolean value;
	
	public BooleanLiteral(String value) {
		if (value.equals("true"))
			this.value = true;
		else
			this.value = false;
	}
	
	public boolean getValue() {
		return value;
	}
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visit(this);
    }
	
	@Override
	public Type typeOf(Map<String, Type> typeEnvironment) {
		return new BoolType();
	}

}
