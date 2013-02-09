package org.uva.sea.ql.ast.type;

public class TypeFactory {

	private static final BooleanType boolType = new BooleanType();
	private static final IntegerType intType = new IntegerType();
	private static final DecimalType decType = new DecimalType();
	private static final MoneyType moneyType = new MoneyType();
	private static final StringType stringType = new StringType();

	private TypeFactory() {

	}

	public static BooleanType getBoolType() {
		return boolType;
	}

	public static IntegerType getIntType() {
		return intType;
	}

	public static DecimalType getDecType() {
		return decType;
	}

	public static MoneyType getMoneyType() {
		return moneyType;
	}

	public static StringType getStringType() {
		return stringType;
	}
	
	
}
