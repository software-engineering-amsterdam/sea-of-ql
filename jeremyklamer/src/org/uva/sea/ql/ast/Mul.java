package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;

public class Mul extends Binary {

	public Mul(Expr left, Expr right) {
		super(left,right);
	}

	@Override
	public Value interpret(){
		IntVal li = (IntVal)(getLeft().interpret());
		IntVal ri = (IntVal)(getRight().interpret());
		return new IntVal(li.getVal() * ri.getVal());	
	}
	
	@Override
	public Type typeOf(Env env) {
		
		Type lt = getLeft().typeOf(env);
		Type rt = getRight().typeOf(env);
		System.out.println("Type lt = " + lt.getClass() + " Type rt = " +rt.getClass());
		if(lt.getClass() == rt.getClass())
			return lt;
		
		else//TODO generate error. 
			return null;
	}
	
}
