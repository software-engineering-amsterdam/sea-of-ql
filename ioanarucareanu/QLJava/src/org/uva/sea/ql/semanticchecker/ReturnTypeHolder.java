package org.uva.sea.ql.semanticchecker;

import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.StringType;

public class ReturnTypeHolder {

	private static final BooleanType boolType = new BooleanType();
	private static final IntegerType intType = new IntegerType();
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

	public static StringType getStringType() {
		return stringType;
	}
	
	
}
