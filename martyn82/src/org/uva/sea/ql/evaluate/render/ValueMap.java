package org.uva.sea.ql.evaluate.render;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ValueMap {
	private final Map<String, Object> values;

	public ValueMap() {
		this.values = new HashMap<String, Object>();
	}

	public void add( String name, Object value ) {
		this.values.put( name, value );
	}

	public Set<Map.Entry<String, Object>> entrySet() {
		return this.values.entrySet();
	}
}
