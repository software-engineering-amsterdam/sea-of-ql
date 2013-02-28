package org.uva.sea.ql.evaluate.render;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.uva.sea.ql.value.Value;

public class RuntimeValueMap {
	private final Map<String, Value> values;

	public RuntimeValueMap() {
		this.values = new HashMap<String, Value>();
	}

	public void add( String name, Value value ) {
		this.values.put( name, value );
	}

	public Set<Map.Entry<String, Value>> entrySet() {
		return this.values.entrySet();
	}
}
