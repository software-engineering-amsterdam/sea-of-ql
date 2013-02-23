package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.ui.components.ActiveComponent;
import org.uva.sea.ql.ui.components.IntComponent;


public class IntType extends Type{
	
	public IntType(){
		
	}

	@Override
	public ActiveComponent getAnswerComponent() {
		return new IntComponent();
	}

	@Override
	public Value getDefaultValue() {
		return new IntVal(0);
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}
	
	@Override
	public boolean isCompatibleToInt() {
		return true;
	}
}
