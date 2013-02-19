package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.ui.components.ActiveComponent;

/*
 * This type is used to catch UndefinedTypes and will never be called to provides a component. 
 */
public class UndefinedType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	
	@Override
	public ActiveComponent getAnswerComponent(Env env, Form form, Ident name) {
		return null;
	}
	
	@Override
	public Value getDefaultValue() {
		return null;
	}

}
