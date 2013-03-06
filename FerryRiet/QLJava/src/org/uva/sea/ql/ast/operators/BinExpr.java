package org.uva.sea.ql.ast.operators;

import java.util.Map;

import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Type;

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
	// Valid for: add, div, mul, sub, Geq, LT, GT, Leq
	public Type typeOf(Map<String, Statement> typeEnv) {
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

	public Type getExprLeftHandType(Map<String, Statement> symbolMap) {
		return exprLeftHand.typeOf(symbolMap);
	}

	public Type getExprRightHandType(Map<String, Statement> symbolMap) {
		return exprRightHand.typeOf(symbolMap);
	}
}
