package org.uva.sea.ql.ast.operators;

import java.util.HashMap;

import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public abstract class BinExpr extends Expr {
	private final Expr exprLeftHand;
	private final Expr exprRightHand;

	public BinExpr(Expr result, Expr rhs) {
		exprLeftHand = result;
		exprRightHand = rhs;
	}

	@Override
	// 
	// Method typeOf 
	// Valid for:  add, div, mul, sub, Geq, LT, GT, Leq  
	public Type typeOf(HashMap<String, Statement> typeEnv) {
		Type rightType = getExprRightHand().typeOf(typeEnv);
		Type leftType = getExprLeftHand().typeOf(typeEnv);

		if (rightType.isCompatibleToString() || leftType.isCompatibleToString())
			return new ErrorType();
		if (rightType.isCompatibleToBool() || leftType.isCompatibleToBool())
			return new ErrorType();
		if (rightType.isCompatibleToMoney() && leftType.isCompatibleToMoney())
			return new MoneyType();
		if (rightType.isCompatibleToMoney() || leftType.isCompatibleToMoney())
			return new MoneyType();
		return new IntegerType();
	}

	public final Expr getExprLeftHand() {
		return exprLeftHand;
	}

	public final Expr getExprRightHand() {
		return exprRightHand;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
