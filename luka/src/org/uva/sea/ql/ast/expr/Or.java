package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;


public class Or extends BinaryExpr{

	//private Expr lhs,rhs;
	
	public Or(Expr lhs, Expr rhs){
		super(lhs,rhs);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new BoolType();
	}
	
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	
}
