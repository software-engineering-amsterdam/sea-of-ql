package org.uva.sea.ql.gui.render;

import org.uva.sea.ql.parser.TypeEnvironment;

public class State {

	private final TypeEnvironment _typeEnvironment;
	
	public State(TypeEnvironment typeEnvironment) {
		_typeEnvironment = typeEnvironment;
	}
	
	public TypeEnvironment getTypeEnvironment() {
		return _typeEnvironment;
	}
}