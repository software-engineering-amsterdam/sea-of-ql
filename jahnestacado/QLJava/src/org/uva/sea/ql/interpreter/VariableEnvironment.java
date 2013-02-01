package org.uva.sea.ql.interpreter;

import java.util.Map;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.swing.Renderer;

public class VariableEnvironment {
	private final String varName;
	Map<String, Value> declaredVar;
	JComponent component;

	public VariableEnvironment(String varName, Map<String, Value> declaredVar,Value value) {
		this.varName = varName;
		this.declaredVar = declaredVar;
		this.component = component;

	}
	
	public static void refreshForm(String varName, Map<String, Value> declaredVar,Value value){
		VariableEnvironment env=new VariableEnvironment(varName,declaredVar,value);
		declaredVar.put(varName, value);
		SwingVisitor.regenerate(declaredVar);
		Renderer render=new Renderer(SwingVisitor.regenerate(declaredVar));

		
	}

}
