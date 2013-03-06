package org.uva.sea.ql.ast.nodes.statements.composite;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.ast.nodes.expressions.Expr;
import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.types.Type;

/**
 * Binary Expression Tree Node
 * @author sroh
 */
public abstract class BinaryStatement extends Expr{
	private final Expr lhs;
	private final Expr rhs;
	public BinaryStatement(Expr lhs, Expr rhs){
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