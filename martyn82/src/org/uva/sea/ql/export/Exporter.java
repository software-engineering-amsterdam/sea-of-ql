package org.uva.sea.ql.export;

import org.uva.sea.ql.evaluate.render.RuntimeValueMap;

abstract public class Exporter {
	protected final String formName;
	protected final RuntimeValueMap values;

	public Exporter( String formName, RuntimeValueMap values ) {
		this.formName = formName;
		this.values = values;
	}

	abstract public void export( String fileName );
}
