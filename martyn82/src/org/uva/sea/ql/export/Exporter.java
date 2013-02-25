package org.uva.sea.ql.export;

import org.uva.sea.ql.evaluate.render.ValueMap;

abstract public class Exporter {
	private final String name;
	private final ValueMap values;

	public Exporter( String formName, ValueMap values ) {
		this.name = formName;
		this.values = values;
	}

	protected String getName() {
		return this.name;
	}

	protected ValueMap getValues() {
		return this.values;
	}

	abstract public void export( String fileName );
}
