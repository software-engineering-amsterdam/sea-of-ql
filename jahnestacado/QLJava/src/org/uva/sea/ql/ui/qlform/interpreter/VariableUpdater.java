package org.uva.sea.ql.ui.qlform.interpreter;

import java.util.Map;

import org.uva.sea.ql.ast.expr.values.Value;

public class VariableUpdater {

	private final Map<String, Value> runTimeValues;

	public VariableUpdater(String varName, Map<String, Value> runTimeValues,Value value) {
		runTimeValues.put(varName, value);
		this.runTimeValues = runTimeValues;

	}

	public Map<String, Value> getUpdatedValues() {
		return runTimeValues;
	}

}
