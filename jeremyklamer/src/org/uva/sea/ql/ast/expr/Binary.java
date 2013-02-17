package org.uva.sea.ql.ast.expr;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.message.Error;
import org.uva.sea.ql.message.Message;


public abstract class Binary extends Expr {

	protected final Expr left;
	protected final Expr right;
	
	public Binary(Expr left, Expr right){
		this.left = left; 
		this.right = right;
	}
	
	@Override 
	public List<Message> checkType(Env env) { // TODO check out double dispatch
		ArrayList<Message> errors = new ArrayList<Message>();
		
		errors.addAll(left.checkType(env));  
		errors.addAll(right.checkType(env)); 		
			
		Type leftType = left.typeOf(env);  
		Type rightType = right.typeOf(env);  
		
		if(!(leftType.isCompatibleTo(rightType))){
			errors.add(new Error(getSimpleName(leftType) + " is not compatible with " + getSimpleName(rightType) + ". In :" + getSimpleName(this)));
		}
		
		return errors;
	}
	
	
	
}
