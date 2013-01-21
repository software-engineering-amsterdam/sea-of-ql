package org.uva.sea.ql.ast.expr.primary;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.FormVisitor;


public class StringLiteral extends Expr {

	private final String value;

	public StringLiteral(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public void accept(FormVisitor visitor) {		
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new StringType();
	}

}
