package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;

public class Mul extends Binary {

	public Mul(Expr left, Expr right) {
		super(left,right);
		permittedTypes = new Numeric();
	}

	@Override
	public Value interpret(){
		IntVal li = (IntVal)(getLeft().interpret());
		IntVal ri = (IntVal)(getRight().interpret());
		return new IntVal(li.getVal() * ri.getVal());	
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new Numeric();
	}
	
}
