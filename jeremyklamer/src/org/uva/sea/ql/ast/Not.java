package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.Map;

import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Value;

public class Not extends Expr {

	private final Expr expr;
	
	public Not(Expr expr) {
		this.expr = expr;
	}

	public Expr getExpr() {
		return expr;
	}
	
	@Override
	public Value interpret() {
		return new BoolVal(!((BoolVal)getExpr().interpret()).getBool());
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new BoolType();
	}
	
	@Override
	public ArrayList<String> checkType(Map<Ident, Type> typeEnv) {
		ArrayList<String> retVal = new ArrayList<String>();
		Type type = typeOf(typeEnv);
		if(!(type.isCompatibleToBool()))
			retVal.add(type + " is not compatible. In " + this.getClass());
		return retVal;	
	}
}
