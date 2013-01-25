package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.Map;

import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;

public class Pos extends Expr {

	private final Expr expr;
	
	public Pos(Expr expr) {
		this.expr = expr;
	}

	public Expr getExpr() {
		return expr;
	}
	
	@Override
	public Value interpret() {
		return (IntVal) getExpr().interpret();
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new Numeric();
	}
	
	@Override
	public ArrayList<String> checkType(Map<Ident, Type> typeEnv) {
		ArrayList<String> retVal = new ArrayList<String>();
		Type type = typeOf(typeEnv);
		if(!(type.isCompatibleToNumeric()))
			retVal.add(type + " is not compatible. In " + this.getClass());
		return retVal;	
	}
}
