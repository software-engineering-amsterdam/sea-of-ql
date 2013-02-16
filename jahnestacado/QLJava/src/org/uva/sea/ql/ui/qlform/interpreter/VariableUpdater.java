package org.uva.sea.ql.ui.qlform.interpreter;

import java.util.Map;

import org.uva.sea.ql.ast.expr.values.Value;

public class VariableUpdater {

	private final Map<String, Value> declaredVar;

	public VariableUpdater(String varName, Map<String, Value> declaredVar,Value value) {
		declaredVar.put(varName, value);
		this.declaredVar = declaredVar;

	}

	public Map<String, Value> getUpdatedValues() {
		return declaredVar;
	}

}
