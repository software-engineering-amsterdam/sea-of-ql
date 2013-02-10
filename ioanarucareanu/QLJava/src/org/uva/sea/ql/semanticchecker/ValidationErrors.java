package org.uva.sea.ql.semanticchecker;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrors {
	private final List<String> errors;

	public ValidationErrors() {
		errors = new ArrayList<String>();
	}
	public List<String> getErrors() {
		return errors;
	}
	
	public void addError(String error) {
		errors.add(error);
	}
}
