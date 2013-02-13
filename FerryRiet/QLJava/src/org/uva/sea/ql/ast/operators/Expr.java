package org.uva.sea.ql.ast.operators;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public abstract class Expr implements ASTNode {
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	public abstract Type typeOf(Map<String, Statement> symbolMap);

	public abstract Result eval(Map<String, Result> symbolMap);
}
