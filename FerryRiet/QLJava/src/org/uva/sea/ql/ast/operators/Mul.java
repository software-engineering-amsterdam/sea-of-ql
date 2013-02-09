package org.uva.sea.ql.ast.operators;

import java.math.BigDecimal;
import java.util.HashMap;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.literals.IntegerResult;
import org.uva.sea.ql.ast.literals.MoneyResult;
import org.uva.sea.ql.ast.literals.Result;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Mul extends BinExpr {

	public Mul(Expr result, Expr rhs) {
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
		// The order of the test for compatibility is important.
		// Case 1 MoneyType - MoneyType
		if ((new MoneyType()).isCompatibleTo(leftHandResult.typeOf())
				&& (new MoneyType()).isCompatibleTo(rightHandResult.typeOf())) {
			return new MoneyResult(leftHandResult.getMoneyValue().multiply(
					rightHandResult.getMoneyValue()));
		}
		// Case 2 MoneyType - Integer
		if ((new MoneyType()).isCompatibleTo(leftHandResult.typeOf())) {
			return new MoneyResult(leftHandResult.getMoneyValue().multiply(
					new BigDecimal(rightHandResult.getIntegerValue())));
		}
		// Case 3 Integer - MoneyType
		if ((new MoneyType()).isCompatibleTo(rightHandResult.typeOf())) {
			return new MoneyResult((new BigDecimal(
					leftHandResult.getIntegerValue()).multiply(rightHandResult
					.getMoneyValue())));
		}
		// Case 4 Integer - Integer
		return new IntegerResult(leftHandResult.getIntegerValue()
				* rightHandResult.getIntegerValue());
	}
}
