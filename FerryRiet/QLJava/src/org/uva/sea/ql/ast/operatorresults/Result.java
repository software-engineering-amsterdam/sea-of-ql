package org.uva.sea.ql.ast.operatorresults;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.types.Type;

public abstract class Result {
	private Type resultType;

	public Result(Type rt) {
		resultType = rt;
	}

	public abstract String toString();

	public abstract int getIntegerValue();

	public abstract String getStringValue();

	public abstract BigDecimal getMoneyValue();

	public abstract boolean getBooleanValue();

	public abstract Type typeOf();

	public boolean isCompatibleToInt() {
		return resultType.isCompatibleToInt();
	}

	public boolean isCompatibleToString() {
		return resultType.isCompatibleToString();
	}

	public boolean isCompatibleToBool() {
		return resultType.isCompatibleToBool();
	}

	public boolean isCompatibleToMoney() {
		return resultType.isCompatibleToMoney();
	}

	public abstract Result setValue(String string);

	public abstract Result add(Result adder);
	public abstract Result doAdd(MoneyResult inte);
	public abstract Result doAdd(IntegerResult inte);

	public abstract Result mul(Result adder);
	public abstract Result doMul(MoneyResult inte);
	public abstract Result doMul(IntegerResult inte);

	public abstract Result div(Result diver);
	public abstract Result doDiv(MoneyResult diver);
	public abstract Result doDiv(IntegerResult diver);

	public abstract Result sub(Result subber);
	public abstract Result doSub(MoneyResult subber);
	public abstract Result doSub(IntegerResult subber);

	public abstract Result eq(Result eq);
	public abstract Result doEq(MoneyResult eq);
	public abstract Result doEq(IntegerResult eq);
	public abstract Result doEq(BooleanResult eq);

	public abstract Result and(Result eq);
	public abstract Result doAnd(BooleanResult ander);
	
	public abstract Result geq(Result g);
	public abstract Result doGeq(MoneyResult g);
	public abstract Result doGeq(IntegerResult g);

	public abstract Result gt(Result g);
	public abstract Result doGt(MoneyResult g);
	public abstract Result doGt(IntegerResult g);

	public abstract Result lt(Result g);
	public abstract Result doLt(MoneyResult g);
	public abstract Result doLt(IntegerResult g);
	
	public abstract Result leq(Result g);
	public abstract Result doLeq(MoneyResult g);
	public abstract Result doLeq(IntegerResult g);

	public abstract Result or(Result eq);
	public abstract Result doOr(BooleanResult ander);

}
