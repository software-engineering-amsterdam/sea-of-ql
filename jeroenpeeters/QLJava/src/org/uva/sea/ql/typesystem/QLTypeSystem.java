package org.uva.sea.ql.typesystem;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.expression.Expression;

public class QLTypeSystem implements ITypeResolver {

	private final Map<Expression, DataType> context;
	
	public QLTypeSystem(){
		this.context = new HashMap<>();
	}
	
	public void register(Expression expr, DataType dt){
		context.put(expr, dt);
	}
	
	public DataType resolve(Expression expr){
		final DataType dt = context.get(expr);
		return dt != null ? dt : DataType.UNDEF;
	}
	
	public DataType cast(final DataType dt1, final DataType dt2) {
		if(dt1 == dt2){
			// types are the same, cast is not needed.
			return dt1;
			
		}else if(isOneOf(dt1, DataType.INTEGER, DataType.MONEY) && isOneOf(dt2, DataType.INTEGER, DataType.MONEY)){
			// on of the types is integer, the other one is money -> cast to money type
			return DataType.MONEY;
			
		}else if((dt1 == DataType.TEXT || dt2 == DataType.TEXT) && (dt1 != DataType.BOOLEAN && dt2 != DataType.BOOLEAN)){
			// on of the types is text and the other is not boolean -> cast to text
			return DataType.TEXT;
		}
		
		// unable to cast the two types to one data type
		return DataType.UNDEF;
	}
	
	private boolean isOneOf(DataType dt, DataType... dts){
		for(DataType d : dts){
			if(dt == d) return true;
		}
		return false;
	}

}