package org.uva.sea.ql.ast.operators;

import java.math.BigDecimal;
import java.util.HashMap;

import org.uva.sea.ql.ast.literals.IntegerResult;
import org.uva.sea.ql.ast.literals.MoneyResult;
import org.uva.sea.ql.ast.literals.Result;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Add extends BinExpr {

	public Add(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public Type typeOf(HashMap<String, Statement> typeEnv) {
		return new IntegerType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Result eval(HashMap<String, Result> symbolMap) {
		Result leftHandResult = getExprLeftHand().eval(symbolMap);
		Result rightHandResult = getExprRightHand().eval(symbolMap);

		// Check types and allow promotion from integer to money, there is no
		// demotion
		// Money is compatible to Integer and Integer IS NOT compatible to Money
		// The order of the tests for compatibility is important.
		// Case 1 MoneyType + MoneyType
		if (leftHandResult.isCompatibleToMoney() && rightHandResult.isCompatibleToMoney()) {
			return new MoneyResult(leftHandResult.getMoneyValue().add(
					rightHandResult.getMoneyValue()));
		}
		// Case 2 MoneyType + Integer
		if (leftHandResult.isCompatibleToMoney()) {
			return new MoneyResult(leftHandResult.getMoneyValue().add(
					new BigDecimal(rightHandResult.getIntegerValue())));
		}
		// Case 3 Integer + MoneyType
		if (rightHandResult.isCompatibleToMoney()) {
			return new MoneyResult(rightHandResult.getMoneyValue().add(
					new BigDecimal(leftHandResult.getIntegerValue())));
		}
		// Case 4 Integer + Integer
		return new IntegerResult(leftHandResult.getIntegerValue()
				+ rightHandResult.getIntegerValue());
	}
}
