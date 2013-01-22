package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.types.NumericType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Div extends Binary {

	public Div(Expr leftExpr, Expr rightExpr) {
		super(leftExpr,rightExpr);
	}

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
		
	}

	@Override
	public Type isOfType(Map<Ident, Type> typeEnv) {
		return new NumericType();
	}

}
