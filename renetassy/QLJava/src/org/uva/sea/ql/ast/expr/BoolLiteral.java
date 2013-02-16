package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.IExprVisitor;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;


public class BoolLiteral extends Expr {
	
	private final String value;
	
	public BoolLiteral(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public <T> T accept(IExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		return new BoolType();
	}

}
