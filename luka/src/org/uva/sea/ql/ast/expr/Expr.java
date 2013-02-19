package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public abstract class Expr extends ASTNode {

	public abstract Type typeOf(Map<Ident, Type> typeEnv);

	public abstract <T> T accept(Visitor<T> visitor);

	@Override
	public String toString() {
		return " abstract Expr";
	}
}
