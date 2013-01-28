package org.uva.sea.ql.ast;

import java.util.HashMap;

import org.uva.sea.ql.ast.nodevisitor.Visitor;
import org.uva.sea.ql.ast.nodevisitor.VisitorResult;
import org.uva.sea.ql.ast.operators.ExpressionResult;
import org.uva.sea.ql.ast.types.TypeDescription;

public abstract class Expr implements ASTNode {
	@Override
	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public abstract TypeDescription typeOf(HashMap<String, Statement> symbolMap);

	public abstract ExpressionResult eval(HashMap<String, Statement> symbolMap);
}
