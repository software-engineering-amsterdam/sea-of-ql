package org.uva.sea.ql.semanticchecker;

import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.DecimalType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.StringType;

public class ReturnTypeHolder {

	private static final BooleanType boolType = new BooleanType();
	private static final IntegerType intType = new IntegerType();
	private static final DecimalType decType = new DecimalType();
	private static final MoneyType moneyType = new MoneyType();
	private static final StringType stringType = new StringType();
	private static final VoidType voidType = new VoidType();

	private ReturnTypeHolder() {

	}
	
	public static final VoidType getVoidType() {
		return voidType;
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
