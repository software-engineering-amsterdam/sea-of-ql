package org.uva.sea.ql.ast.expressions.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;
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
	public List<Message> checkType(Map<Ident, Type> typeEnv) {
		List<Message> errors = new ArrayList<Message>();
		
		errors.addAll(left.checkType(typeEnv));
		errors.addAll(right.checkType(typeEnv));
		
		if (!left.typeOf(typeEnv).equals(right.typeOf(typeEnv))) {
			errors.add(new Error("The type of the left and right expression of " + getName() + " should be of the same type"));
		}
		else if (!this.allowedTypes.contains(left.typeOf(typeEnv))) {
			errors.add(new Error("The type of the left and right arguments are not allowed in operation " + getName()));
		}
		
		return errors;
	}
}
