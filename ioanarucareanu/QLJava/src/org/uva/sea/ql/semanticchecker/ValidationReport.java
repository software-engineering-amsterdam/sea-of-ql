package org.uva.sea.ql.semanticchecker;

import java.util.ArrayList;
import java.util.List;

public class ValidationReport {
	
	private final List<String> errors;
	private final List<String> warnings;

	public ValidationReport() {
		errors = new ArrayList<String>();
		warnings = new ArrayList<String>();
	}
	public List<String> getErrors() {
		return errors;
	}
	
	public List<String> getWarnings() {
		return warnings;
	}
	
	public void addError(String error) {
		errors.add(error);
	}
	
	public void addWarning(String warning) {
		warnings.add(warning);
	}
}
