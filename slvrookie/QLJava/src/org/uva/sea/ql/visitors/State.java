package org.uva.sea.ql.visitors;

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
		return null;
	}

}
