package org.uva.sea.ql.visitors.utils;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.ast.types.Type;

public class State {

	private final Map<String, Type> typeEnv;
	private final Map<String, Value> valuEnv;

	public State() {
		this.valuEnv = new HashMap<String, Value>();
		this.typeEnv = new HashMap<String, Type>();
	}

	public Map<String, Value> getValueEnv() {
		return valuEnv;
	}

	public Map<String, Type> getTypeEnv() {
		return typeEnv;
	}

	public boolean hasRegisteredType(String name) {
		if (typeEnv.containsKey(name)) {
			return true;
		}
		return false;
	}
	
	public void clear() {
		typeEnv.clear();
		valuEnv.clear();
	}

	public void setType(String name, Type type) {
		typeEnv.put(name, type);
	}

	public boolean hasRegisteredValue(String name) {
		if (valuEnv.containsKey(name)) {
			return true;
		}
		return false;
	}

	public void setValue(String name, Value val) {
		valuEnv.put(name, val);
	}

	public Value getValue(String name) {
		if (valuEnv.containsKey(name)) {
			return valuEnv.get(name);
		}
		throw new RuntimeException("Undefined ident: " + name); 
	}
	
	/* 
	 * 	getValue(String name) will never return null due to the
	 *  requirement for sequential processing of the ql.
	 *  
	 *  REQ:
	 * "the ordering of questions should be consistent with how the 
	 * question variables are used in conditions and computed values."
	 * 
	 * non declared idents that exist in expressions and
	 * conditions are caught during the typecheking phase.
	 * 
	 * Sequential processing and value initializer 
	 * also guarantee that idents that exist in
	 * expressions and conditions have a value assigned
	 */
}
