package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.message.Error;
import org.uva.sea.ql.message.Message;


public abstract class Binary extends Expr {

	private Expr left;
	private Expr right;
	
	public Binary(Expr left, Expr right){
		this.left = left; 
		this.right = right;
	}
	
	protected Expr getLeft(){
		return left; 
	}
	
	protected Expr getRight(){
		return right;
	}
	
	@Override 
	public List<Message> checkType(Map<Ident, Type> typeEnv) { // TODO check out double dispatch
		ArrayList<Message> errors = new ArrayList<Message>();
		
		errors.addAll(getLeft().checkType(typeEnv));  
		errors.addAll(getRight().checkType(typeEnv)); 		
			
		Type leftType = getLeft().typeOf(typeEnv);  
		Type rightType = getRight().typeOf(typeEnv);  
		
		// Have to check both ways because int is not compatible to numeric but numeric is compatible to int. 
		if(!(leftType.isCompatibleTo(rightType) || rightType.isCompatibleTo(leftType)) ){
			errors.add(new Error(getSimpleName(leftType) + " is not compatible with " + getSimpleName(rightType) + ". In :" + getSimpleName(this)));
		}
		else if(!permittedTypes.isCompatibleTo(leftType)){
			errors.add(new Error(getSimpleName(leftType) + " is permitted in :" + getSimpleName(this)));
		}
		
		return errors;
	}
	
}
