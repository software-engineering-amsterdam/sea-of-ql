package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Not extends UnaryExpr{

	public Not(Expr expr){
		super(expr);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new BoolType();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	
}
