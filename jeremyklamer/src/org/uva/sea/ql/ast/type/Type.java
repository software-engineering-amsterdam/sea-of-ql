package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.ui.components.ActiveComponent;


public abstract class Type implements ASTNode{
	
	public abstract boolean isCompatibleTo(Type t);
	public boolean isCompatibleToInt() { return false; }
	public boolean isCompatibleToStr() { return false; }
	public boolean isCompatibleToBool() { return false; }
	
	public abstract ActiveComponent getAnswerComponent(Env env, Form form, Ident name);
	public abstract Value getDefaultValue();
}
