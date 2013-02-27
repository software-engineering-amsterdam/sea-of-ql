package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.interpreter.StringVal;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.ui.components.ActiveComponent;
import org.uva.sea.ql.ui.components.StringComponent;


public class StringType extends Type{
	
	public StringType(){
		
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStr();   
	}
	
	@Override
	public boolean isCompatibleToStr(){
		return true;
	}

	@Override
	public ActiveComponent getAnswerComponent() {
		return new StringComponent(); 	
	}

	@Override
	public Value getDefaultValue() {
		return new StringVal("");
	}

}
