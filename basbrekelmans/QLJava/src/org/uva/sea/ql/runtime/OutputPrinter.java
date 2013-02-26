package org.uva.sea.ql.runtime;

import java.io.IOException;
import java.io.Writer;

import org.uva.sea.ql.ast.form.Form;

public abstract class OutputPrinter {

	private final RuntimeValues variables;
	private final String formName;

	public OutputPrinter(final Form form, final RuntimeValues variables) {
		this.variables = variables;
		this.formName = form.getName();
	}

	public String getFormName() {
		return this.formName;
	}

	protected RuntimeValues getVariables() {
		return this.variables;
	}

	public abstract void printCurrentState(Writer writer) throws IOException;

}
