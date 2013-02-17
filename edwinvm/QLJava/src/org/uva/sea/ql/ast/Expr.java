package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.parser.SupportedTypes;

public abstract class Expr implements ASTNode {
	
	public abstract Type typeOf(SupportedTypes supportedTypes);
	
	public abstract <T> T accept(Visitor<T> visitor);
	
}