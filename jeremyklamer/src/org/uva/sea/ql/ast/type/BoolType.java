package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.ui.components.ActiveComponent;
import org.uva.sea.ql.ui.components.BoolComponent;


public class BoolType extends Type{
		
	public BoolType(){
		
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBool();
	}

	@Override
	public boolean isCompatibleToBool() {
		return true;
	}

	@Override
	public ActiveComponent getAnswerComponent() {
		return new BoolComponent();
	}

	@Override
	public Value getDefaultValue() {
		return new BoolVal(false);
	}
}
