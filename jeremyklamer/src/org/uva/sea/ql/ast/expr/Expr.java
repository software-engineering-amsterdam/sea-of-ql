package org.uva.sea.ql.ast.expr;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.message.Message;

public abstract class Expr implements ASTNode {
	
	//protected Type permittedTypes;
	
	protected static String getSimpleName(Object e) { 
		return e.getClass().getSimpleName();
	}

	public abstract Value eval(Env env);
	
	public abstract Type typeOf(Env env);
	
	public abstract List<Message> checkType(Env env);
	
	public void fillIdents(Map<Ident, Type> input) {
		
	}
}
