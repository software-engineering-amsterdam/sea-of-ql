package org.uva.sea.ql.ast.expressions.binary;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.messages.Message;
import org.uva.sea.ql.messages.Error;

public abstract class Binary extends Expr {
	private Expr left;
	private Expr right;
	
	public Binary(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}
	
	public Expr getLeft() {
		return left;
	}
	
	public Expr getRight() {
		return right;
	}

	@Override
	public List<Message> checkType(Env environment) {
		List<Message> errors = new ArrayList<Message>();
		
		errors.addAll(left.checkType(environment));
		errors.addAll(right.checkType(environment));
		
		if (!left.typeOf(environment).equals(right.typeOf(environment))) {
			errors.add(new Error(
					"The type of the left and right expression of " + getName() + 
					" should be of the same type, left is " + left.typeOf(environment) + 
					" and right is " + right.typeOf(environment)));
		}
		else if (!allowedArgumentTypes().contains(left.typeOf(environment))) {
			errors.add(new Error(
					"The type of the left and right arguments are not allowed in operation " + getName() + 
					" allowed types are: " + getPrintableAllowedTypes() + ". Gotten " + left.typeOf(environment)));
		}
		
		return errors;
	}
}
