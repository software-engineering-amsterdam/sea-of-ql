package org.uva.sea.ql.ast.operators;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.Type;

public abstract class Expr implements ASTNode {
	public abstract Type typeOf(Map<String, Statement> symbolMap);

	public abstract Result eval(Map<String, Result> symbolMap);
}
