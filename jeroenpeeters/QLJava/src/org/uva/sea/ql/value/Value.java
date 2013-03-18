package org.uva.sea.ql.value;

import org.uva.sea.ql.ast.type.Type;

public interface Value {

	Type getType();
	
	// Binary
	
	Value add(Value otherValue);
	
	Value addInteger(IntegerValue otherValue);
	
	Value addMoney(MoneyValue otherValue);
	
	Value and(Value otherValue);
	
	Value andBool(BooleanValue otherValue);
	
	Value div(Value otherValue);
	
	Value divInteger(IntegerValue otherValue);
	
	Value divMoney(MoneyValue otherValue);
	
	Value eq(Value otherValue);
	
	Value eqInteger(IntegerValue otherValue);
	
	Value eqMoney(MoneyValue otherValue);
	
	Value eqBool(BooleanValue otherValue);
	
	Value geq(Value otherValue);
	
	Value geqInteger(IntegerValue otherValue);
	
	Value geqMoney(MoneyValue otherValue);
	
	Value gt(Value otherValue);
	
	Value gtInteger(IntegerValue otherValue);
	
	Value gtMoney(MoneyValue otherValue);
	
	Value leq(Value otherValue);
	
	Value leqInteger(IntegerValue otherValue);
	
	Value leqMoney(MoneyValue otherValue);
	
	Value lt(Value otherValue);
	
	Value ltInteger(IntegerValue otherValue);
	
	Value ltMoney(MoneyValue otherValue);
	
	Value mul(Value otherValue);
	
	Value mulInteger(IntegerValue otherValue);
	
	Value mulMoney(MoneyValue otherValue);
	
	Value neq(Value otherValue);
	
	Value neqInteger(IntegerValue otherValue);
	
	Value neqMoney(MoneyValue otherValue);
	
	Value neqBool(BooleanValue otherValue);
	
	Value or(Value otherValue);
	
	Value orBool(BooleanValue otherValue);
	
	Value sub(Value otherValue);
	
	Value subInteger(IntegerValue otherValue);
	
	Value subMoney(MoneyValue otherValue);
	
	// Unary
	
	Value neg();
	
	Value not();
	
	Value pos();

}
