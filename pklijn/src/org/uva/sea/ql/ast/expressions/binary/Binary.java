package org.uva.sea.ql.ast.expressions.binary;

import java.util.List;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.Type;

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
	public List<String> checkType(List<String> errors) {
		Type leftType = getLeft().typeOf(null);
		Type rightType = getRight().typeOf(null);
		// TODO: niet dit maar getleft and getRight .checkType()
		if (leftType != rightType) { // TODO: equals!
			errors.add("The left and right value are not of the same type.");
		}
		
		return errors;
	}
}
