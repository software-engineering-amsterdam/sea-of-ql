package org.uva.sea.ql.ast.type;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.bool.BooleanVariable;
import org.uva.sea.ql.ast.expression.integer.IntegerVariable;
import org.uva.sea.ql.ast.expression.string.StringVariable;
import org.uva.sea.ql.ast.expression.variable.Variable;


public class Type {
	
	private final String type;
	
	public Type(String type) throws TypeNotSupportedException {
		if (isSupportedType(type)) {
			this.type = type;
		} else {
			throw new TypeNotSupportedException();
		}
	}
	
	public String getType() {
		return type;
	}
	
	public Variable getVariableForType(Identifier id) throws TypeNotSupportedException {
		Variable var = null;
		Map<String, Class<? extends Variable>> type2variable = getType2VariableMapping();
		Class<? extends Variable> class_name = type2variable.get(type);
		try {
			var = class_name.newInstance();
		} catch( Exception e ) {
			throw new TypeNotSupportedException();
		}
		return var;
	}
	
	private Map<String, Class<? extends Variable>> getType2VariableMapping() {
		Map<String, Class<? extends Variable>> type2variable = new HashMap<String, Class<? extends Variable>>();
		type2variable.put("boolean", BooleanVariable.class);
		type2variable.put("integer", IntegerVariable.class);
		type2variable.put("string",  StringVariable.class );
		return type2variable;
	}
	
	private boolean isSupportedType(String type) {
		Map<String, Class<? extends Variable>> type2variable = getType2VariableMapping();
		return type2variable.containsKey(type);
	}
}
