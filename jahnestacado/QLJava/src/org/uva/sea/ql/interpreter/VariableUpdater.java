package org.uva.sea.ql.interpreter;

import java.util.Map;

import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.swing.Renderer;

public  class VariableUpdater {
	
	private final Map<String, Value> declaredVar;
	
	
	public VariableUpdater(String varName, Map<String, Value> declaredVar,Value value){
		
		declaredVar.put(varName, value);
		this.declaredVar=declaredVar;

	}
	
	public Map<String, Value> getUpdatedValues(){
		return declaredVar;
	}

}
