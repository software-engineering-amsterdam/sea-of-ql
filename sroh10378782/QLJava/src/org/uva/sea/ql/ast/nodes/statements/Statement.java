package org.uva.sea.ql.ast.nodes.statements;

import java.util.Map;
import org.uva.sea.ql.ast.nodes.ASTNode;
import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.ast.statements.visitor.Visitable;
import org.uva.sea.ql.ast.statements.visitor.Visitor;
import org.uva.sea.ql.types.Type;

public abstract class Statement implements ASTNode, Visitable{
	public abstract Type getType();
	public abstract Type typeOf(Map<Ident, Type> typeEnvironment);
	public abstract void accept(Visitor visitor);
}