package org.uva.sea.ql.visitor.semantic;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
	private final List<String> errors;

	public ValidationResult() {
		this.errors = new ArrayList<String>();
	}

	public boolean isValid() {
		return this.errors.isEmpty();
	}

	public List<String> getErrors() {
		return this.errors;
	}

	public void addError(String error) {
		this.errors.add(error);
	}

	public void addValidationResult(ValidationResult validationResult) {
		this.errors.addAll(validationResult.getErrors());
	}

}
