package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.checkers.ExpressionChecker;


public class And extends Binary {

	public And(Expr leftExpr, Expr rightExpr) {
		super(leftExpr,rightExpr);
	}

	@Override
	public boolean accept(ExpressionChecker nodeVisitor) {
		return nodeVisitor.visit(this);
		
	}
	
	@Override
	public Type isOfType(Map<String, Type> typeEnv) {
		return new BoolType();
	}

}
