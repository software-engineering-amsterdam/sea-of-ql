package org.uva.sea.ql.ast.operators;

import java.util.HashMap;

import org.uva.sea.ql.ast.BinExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.types.NumeralType;
import org.uva.sea.ql.ast.types.TypeDescription;
import org.uva.sea.ql.astnodevisitor.Visitor;
import org.uva.sea.ql.astnodevisitor.VisitorResult;

public class Add extends BinExpr {

	public Add(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public TypeDescription typeOf(HashMap<String, Statement> typeEnv) {
		return new NumeralType();
	}
	@Override
	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
