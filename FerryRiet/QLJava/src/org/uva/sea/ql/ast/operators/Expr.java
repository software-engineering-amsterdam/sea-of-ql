package org.uva.sea.ql.ast.operators;

import java.util.HashMap;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.literals.Result;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public abstract class Expr implements ASTNode {
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	public abstract Type typeOf(HashMap<String, Statement> symbolMap);

	public abstract Result eval(
			HashMap<String, Result> symbolMap);
}
