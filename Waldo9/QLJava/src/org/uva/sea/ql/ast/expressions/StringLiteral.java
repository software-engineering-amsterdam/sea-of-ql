package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;

public class StringLiteral extends Expr {
	
	private final String value;
	
	public StringLiteral(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visit(this);
    }

	@Override
	public Type typeOf(Map<String, Type> typeEnvironment) {
		return new StringType();
	}

}
