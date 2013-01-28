package org.uva.sea.ql.ast.operators;

import java.util.HashMap;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.UnExpr;
import org.uva.sea.ql.ast.nodevisitor.Visitor;
import org.uva.sea.ql.ast.nodevisitor.VisitorResult;
import org.uva.sea.ql.ast.types.NumeralType;
import org.uva.sea.ql.ast.types.TypeDescription;

public class Neg extends UnExpr {

	public Neg(Expr x) {
		super(x);
	}

	@Override
	public TypeDescription typeOf(HashMap<String, Statement> typeEnv) {
		return new NumeralType();
	}

	@Override
	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public ExpressionResult eval(HashMap<String, Statement> symbolMap) {
		// TODO Auto-generated method stub
		return null;
	}
}
