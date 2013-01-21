package org.uva.sea.ql.ast.expr.primary;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.FormVisitor;


public class Bool extends Expr {
	private final boolean value;

	public Bool(boolean value) {
		this.value = value;
	}
	
	public boolean getValue() {
		return value;
	}

	@Override
	public void accept(FormVisitor visitor) {		
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new BooleanType();
	}

}
