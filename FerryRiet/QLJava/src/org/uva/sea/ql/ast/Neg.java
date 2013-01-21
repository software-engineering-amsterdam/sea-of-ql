package org.uva.sea.ql.ast;

import java.util.HashMap;

import org.uva.sea.ql.astnodevisitor.Visitor;
import org.uva.sea.ql.astnodevisitor.VisitorResult;

public class Neg extends UnExpr {

	public Neg(Expr x) {
		super(x);
	}

	@Override
	public TypeDescription typeOf(HashMap<Ident, Statement> typeEnv) {
		return new NumeralType();
	}
	@Override
	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}
}

