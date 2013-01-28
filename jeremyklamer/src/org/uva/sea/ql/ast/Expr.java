package org.uva.sea.ql.ast;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.message.Message;

public abstract class Expr implements ASTNode {
	
	protected Type permittedTypes;
	
	protected static String getName(Object e) { 
		return e.getClass().getSimpleName();
	}

	public abstract Value interpret();
	
	public abstract Type typeOf(Map<Ident, Type> typeEnv);
	
	public abstract List<Message> checkType(Map<Ident, Type> typeEnv);
	
	public void fillIdents(Map<Ident, Type> input) {
		
	}
}
