package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.ui.components.ActiveComponent;


public class UndefinedType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	//This type is used to catch UndefinedTypes and will never be called to provides a component. 
	@Override
	public ActiveComponent getAnswerComponent(Env env, Form form, Ident name) {
		return null;
	}
	
	@Override
	public Value getDefaultValue() {
		return null;
	}

}
