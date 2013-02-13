package org.uva.sea.ql.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Identifier;

public class RuntimeContext {
	private final List<Variable> ifVariables = new ArrayList<Variable>();
	private final Map<Identifier, Variable> questionVariables = new HashMap<Identifier, Variable>();
	
	public RuntimeContext(Iterable<Variable> variables) {
		for (Variable var : variables) {
			if (var.hasIdentifier()) {
				questionVariables.put(var.getIdentifier(), var);
			} else {
				ifVariables.add(var);	
			}
			
		}
	}
	
	public Value getValue(Identifier identifier) {
		return questionVariables.get(identifier).getValue();
	}
}
