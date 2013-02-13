package org.uva.sea.ql.interpreter;

import java.util.ArrayList;
import java.util.List;

public class QLOutputState {
	private final List<String> questionLabels;
	private final List<String> questionValues;
	private boolean hasError = false;

	public QLOutputState() {
		questionLabels = new ArrayList<String>();
		questionValues = new ArrayList<String>();
	}

	public void addValue(String value) {
		questionValues.add(value);
	}

	public void addLabelText(String value) {
		questionLabels.add(value);
	}

	public List<String> getQuestionLabels() {
		return questionLabels;
	}

	public List<String> getQuestionValues() {
		return questionValues;
	}

	public void setErrorFlag(boolean hasError) {
		this.hasError = hasError;
	}

	public boolean hasError() {
		return hasError;
	}
}
