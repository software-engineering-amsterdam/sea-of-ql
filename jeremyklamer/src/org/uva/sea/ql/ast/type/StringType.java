package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.interpreter.Env;
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
	public ActiveComponent getAnswerComponent(Env env, Form form,Ident name) {
		return new StringComponent(env, form, name); 	
	}

	@Override
	public Value getDefaultValue() {
		return new StringVal("");
	}

}
