package org.uva.sea.ql.error;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler implements Serializable {

	private static final long serialVersionUID = -8269697329363883138L;
	
	private List<QLError> errors = new ArrayList<QLError>();

	public void addError(QLError error) {
		errors.add(error);
	}

	public List<QLError> getErrors() {
		return errors;
	}

	public void printErrors() {
		for (QLError error : errors) {
			System.out.println("E: " + error.getCause());
		}
	}

	public boolean hasErrors() {
		return errors.size() > 0;
	}

	public void reportOperationTypeError(String operation, int lineNumber) {
		QLError error = new QLError("Invalid type for operation: " + operation + " at line: " + lineNumber);
		errors.add(error);
	}

	public void clear() {
		errors.clear();
	}

}
