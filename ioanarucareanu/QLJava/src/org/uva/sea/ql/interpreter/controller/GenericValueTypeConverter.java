package org.uva.sea.ql.interpreter.controller;

import java.util.Collection;
import java.util.Locale;

import org.uva.sea.ql.ast.expr.value.BooleanVal;
import org.uva.sea.ql.ast.expr.value.IntegerVal;
import org.uva.sea.ql.ast.expr.value.Val;

import net.sourceforge.stripes.validation.TypeConverter;
import net.sourceforge.stripes.validation.ValidationError;

public class GenericValueTypeConverter implements TypeConverter<Val> {

	/**
	 * Validates the user input to ensure that it is a valid value.
	 * 
	 * @param input the String input, always a non-null non-empty String
     * @param targetType any concrete class from the Type hierarchy
     * @param errors a non-null collection of errors to populate in case of error
	 */

	@Override
	public void setLocale(Locale arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Val convert(String arg0, Class<? extends Val> arg1,
			Collection<ValidationError> arg2) {
		if (arg1.equals(BooleanVal.class)) {
			return new BooleanVal(Boolean.valueOf(arg0));
		}
		if (arg1.equals(IntegerVal.class)) {
			return new IntegerVal(Integer.valueOf(arg0));
		}
		return null;
	}

//	@Override
//	public Integer convert(String input, Class<? extends Integer> arg1,
//			Collection<ValidationError> arg2) {
//		// TODO Auto-generated method stub
//		try {
//	        int result = Integer.parseInt(input);
//	        return result;
//	    }
//	    catch(NumberFormatException e ) {
//	    	return 0;
//	    }
//	}
}
