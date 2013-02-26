package org.uva.sea.ql.export;

import org.uva.sea.ql.evaluate.render.ValueMap;

abstract public class Exporter {
	protected final String formName;
	protected final ValueMap values;

	public Exporter( String formName, ValueMap values ) {
		this.formName = formName;
		this.values = values;
	}

	abstract public void export( String fileName );
}
