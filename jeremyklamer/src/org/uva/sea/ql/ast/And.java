package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.Map;

import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Value;

public class And extends Binary {

	public And(Expr left, Expr right) {
		super(left,right);
	}

	@Override
	public Value interpret() {
		BoolVal lb = (BoolVal) getLeft().interpret();
		BoolVal rb = (BoolVal) getRight().interpret();
		return new BoolVal(lb.getBool() && rb.getBool());
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new BoolType();
	}
	
	@Override
	public ArrayList<String> checkType(Map<Ident, Type> typeEnv) {
		ArrayList<String> retVal = new ArrayList<String>();
		
		retVal.addAll(getLeft().checkType(typeEnv));
		retVal.addAll(getRight().checkType(typeEnv));		
			
		Type leftType = getLeft().typeOf(typeEnv);  
		Type rightType = getRight().typeOf(typeEnv);  
		if(!(leftType.isCompatibleToBool() && rightType.isCompatibleToBool())){
			retVal.add(leftType + " is not compatible with " + rightType + ". In " + this.getClass());
		}
		return retVal;
	}
}
