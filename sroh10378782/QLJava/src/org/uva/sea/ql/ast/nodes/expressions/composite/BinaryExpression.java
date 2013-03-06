package org.uva.sea.ql.ast.nodes.expressions.composite;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.ast.nodes.expressions.Expr;
import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.types.Type;

/**
 * Binary Expression Tree Node
 * Represents all Expressions with a left hand side Expression
 * and a right hand side Expression. 
 * All Expressions who need to hold two other Expressions are inherited from the
 * Binary Expression Tree Node
 * 
 * Pattern Uses:
 * Interpreter pattern : typeOf to determine the Type of the Expression
 * Visitor pattern : accept to traverse the Expression with different Expression Visitors
 * 
 * @author Sven Rohde <svenrohde.se@gmail.com> / 10378782
 */
public abstract class BinaryExpression extends Expr{
	private final Expr lhs;
	private final Expr rhs;
	public BinaryExpression(Expr lhs, Expr rhs){
		this.lhs = lhs;
		this.rhs  = rhs;
	}
	public Expr getLhs() {
		return this.lhs;
	}
	public Expr getRhs() {
		return this.rhs;
	}	
	@Override
	public abstract Type typeOf(Map<Ident,Type> typeEnv);
	@Override
	public abstract <T> T accept(Visitor<T> visitor);
}