package org.uva.sea.ql.ast;

import java.util.HashMap;

import org.uva.sea.ql.astnodevisitor.Visitor;
import org.uva.sea.ql.astnodevisitor.VisitorResult;

public abstract class Expr implements ASTNode {
	@Override
	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public abstract TypeDescription typeOf(HashMap<String, Statement> symbolMap);
}
