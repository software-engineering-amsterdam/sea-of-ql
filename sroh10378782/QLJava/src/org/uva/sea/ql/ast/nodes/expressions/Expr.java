package org.uva.sea.ql.ast.nodes.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitable;
import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.ast.nodes.ASTNode;
import org.uva.sea.ql.types.Type;
/**
 * Expression parent class
 * 
 * Pattern Uses:
 * Interpreter pattern : typeOf to determine the Type of the Expression
 * Visitor pattern : accept to traverse the Expression with different Expression Visitors
 * 
 * @author Sven Rohde
 */
public abstract class Expr implements ASTNode, Visitable {
	@Override
	public abstract <T> T accept(Visitor<T> visitor);
	public abstract Type typeOf(Map<Ident, Type> typeEnv);
}