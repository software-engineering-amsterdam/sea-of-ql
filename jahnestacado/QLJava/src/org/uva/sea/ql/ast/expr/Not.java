package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Not extends Unary {

	public Not(Expr leftExpr) {
		super(leftExpr);
	}

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Type isOfType(Map<Ident, Type> typeEnv) {
		return new BoolType();
	}

}
