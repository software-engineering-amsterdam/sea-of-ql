package org.uva.sea.ql.ast.literals;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;

public class BooleanLiteral extends Expr {
	
	private boolean value;
	
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
	public Type typeOf(Map<Ident, Type> typeEnvironment) {
		return new BoolType();
	}

}
