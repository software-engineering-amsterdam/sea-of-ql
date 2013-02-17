package org.uva.sea.ql.visitors;

import java.util.ArrayList;
import java.util.List;

public class Errors {
	
	private final List<String> errors;

	public Errors() {
		this.errors = new ArrayList<String>();
	}

	public void addError(String error) {
		this.errors.add(error);
	}

	public void getErrors() {
		for (String error : errors) {
			System.out.println(error);
		}
	}

	public List<String> returnErrors() {
		return errors;
	}

	public boolean isEmpty() {
		return errors.isEmpty();
	}
}
