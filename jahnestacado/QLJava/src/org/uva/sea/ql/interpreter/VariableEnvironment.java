package org.uva.sea.ql.interpreter;

import java.util.Map;

import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.swing.Renderer;

public abstract class VariableEnvironment {
	
	
	public static void refreshForm(String varName, Map<String, Value> declaredVar,Value value){
		declaredVar.put(varName, value);
		Renderer.refresh(SwingVisitor.regenerate(declaredVar));
	}

}
