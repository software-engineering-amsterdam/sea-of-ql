package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.Map;

import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;

public class GT extends Binary{

	public GT(Expr left, Expr right) {
		super(left,right);
	}

	@Override
	public Value interpret(){
		IntVal li = (IntVal)(getLeft().interpret());
		IntVal ri = (IntVal)(getRight().interpret());
		return new BoolVal( li.getVal() > ri.getVal());
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new Numeric();
	}
	
	@Override
	public ArrayList<String> checkType(Map<Ident, Type> typeEnv) {
		ArrayList<String> retVal = new ArrayList<String>();
		
		retVal.addAll(getLeft().checkType(typeEnv));
		retVal.addAll(getRight().checkType(typeEnv));		
			
		Type leftType = getLeft().typeOf(typeEnv);  
		Type rightType = getRight().typeOf(typeEnv);  
		if(!(leftType.isCompatibleToNumeric() && rightType.isCompatibleToNumeric())){
			retVal.add(leftType + " is not compatible with " + rightType + ". In " + this.getClass());
		}
		return retVal;
	}
	
}
