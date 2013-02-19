package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.ui.components.ActiveComponent;
import org.uva.sea.ql.ui.components.IntComponent;


public class IntType extends Type{
	
	public IntType(){
		
	}

	@Override
	public ActiveComponent getAnswerComponent(final Env env, final Form form, final Ident name) {
		return new IntComponent(env, form, name);
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
