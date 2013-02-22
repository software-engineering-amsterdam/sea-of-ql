package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.parser.TypeEnvironment;

public abstract class Expr implements ASTNode {
	
	public abstract Type typeOf(TypeEnvironment typeEnvironment);
	
	public abstract <T> T accept(Visitor<T> visitor);
	
}