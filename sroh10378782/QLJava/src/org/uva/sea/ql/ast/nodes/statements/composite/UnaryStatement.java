package org.uva.sea.ql.ast.nodes.statements.composite;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.ast.nodes.expressions.Expr;
import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.types.Type;

/**
 * Abstract class Unary Expression
 * Represents an Tree Node with just one Expr
 * A Non Terminal in the AST with one Expression
 * @author Sven Rohde <svenrohde.se@gmail.com> / 10378782
 */
public abstract class UnaryStatement extends Expr{
	private final Expr primary;
	public UnaryStatement(Expr primary){
		this.primary = primary;
	}
	public Expr getExpr() {
		return this.primary;
	}
	@Override
	public abstract Type typeOf(Map<Ident, Type> typeEnv);
	@Override
	public abstract <T> T accept(Visitor<T> visitor);
}
