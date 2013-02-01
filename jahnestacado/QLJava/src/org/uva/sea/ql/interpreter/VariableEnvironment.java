package org.uva.sea.ql.interpreter;

import java.util.Map;

import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.swing.Renderer;

public class VariableEnvironment {
	private final String varName;
	private final Map<String, Value> declaredVar;
	private final Value value;

	public VariableEnvironment(String varName, Map<String, Value> declaredVar,Value value) {
		this.varName = varName;
		this.declaredVar = declaredVar;
		this.value = value;

	}
	
	public static void refreshForm(String varName, Map<String, Value> declaredVar,Value value){
		VariableEnvironment env=new VariableEnvironment(varName,declaredVar,value);
		System.out.println(declaredVar.get(varName)+" 1st");
		declaredVar.put(varName, value);
		System.out.println(declaredVar.get(varName)+" 2st");

		Renderer.refresh(SwingVisitor.regenerate(declaredVar));
		
		
	}

}
