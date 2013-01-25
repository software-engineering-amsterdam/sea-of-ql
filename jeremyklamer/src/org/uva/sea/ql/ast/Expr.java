package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Value;

public abstract class Expr implements ASTNode {
	
	public abstract Value interpret();
	
	public abstract Type typeOf(Map<Ident, Type> typeEnv);
	
	public abstract ArrayList<String> checkType(Map<Ident, Type> typeEnv);
}
