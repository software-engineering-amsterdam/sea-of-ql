package org.uva.sea.ql.ast;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Value;

public class Binary extends Expr {
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
	public Value eval() {
		throw new UnsupportedOperationException("Can't get a value from a Binary class");
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return null;
	}

	@Override
	public List<String> checkType(List<String> errors) {
		Type leftType = getLeft().typeOf(null);
		Type rightType = getRight().typeOf(null);
		
		if (leftType != rightType) {
			errors.add("The left and right value are not of the same type.");
		}
		
		return errors;
	}
}
