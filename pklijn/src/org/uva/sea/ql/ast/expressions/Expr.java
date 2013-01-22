package org.uva.sea.ql.ast.expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.messages.*;

public abstract class Expr implements ASTNode {
	
	protected final List<Type> allowedTypes = new ArrayList<Type>();

	public abstract Value eval();
	
	public abstract Type typeOf(Map<Ident, Type> typeEnv);
	
	public abstract List<Message> checkType(Map<Ident, Type> typeEnv);
	
	public String getName() {
		return getClass().toString();
	}
}
