package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Environment;

public abstract class Expr implements ASTNode {
	
	public abstract <T> T accept(IVisitor<T> visitor);
	public abstract Type typeOf(Environment env);
	public abstract Primitive interpret(Environment env) throws Exception;
}
