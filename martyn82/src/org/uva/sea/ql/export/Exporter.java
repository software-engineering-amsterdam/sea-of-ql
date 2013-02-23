package org.uva.sea.ql.export;

import java.util.Map;

abstract public class Exporter {
	private final String name;
	private final Map<String, Object> values;

	public Exporter( String formName, Map<String, Object> values ) {
		this.name = formName;
		this.values = values;
	}

	protected String getName() {
		return this.name;
	}

	protected Map<String, Object> getValues() {
		return this.values;
	}

	abstract public void export( String fileName );
}
