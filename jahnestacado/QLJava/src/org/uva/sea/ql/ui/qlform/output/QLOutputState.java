package org.uva.sea.ql.ui.qlform.output;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ui.qlform.interpreter.VariableUpdater;
import org.uva.sea.ql.visitor.evaluator.values.Value;

public class QLOutputState {
	private final List<String> questionLabels;
	private final List<String> questionValues;
	private boolean hasError = false;
	private  VariableUpdater varUpdater;

	public QLOutputState(VariableUpdater varUpdater) {
		this.varUpdater=varUpdater;
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

	public List<String> getQuestionVisibleValues() {
		return questionValues;
	}

	public void setErrorFlag(boolean hasError) {
		this.hasError = hasError;
	}

	public boolean hasError() {
		return hasError;
	}
	
	public Map<String,Value> getAllRunTimeValues(){
		return varUpdater.getUpdatedValues();
	}
}
