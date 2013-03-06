package org.uva.sea.ql.ast.alg;

import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.NumericType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.AlgebricElementVisitor;

public class Add extends Binary {

	public Add(Expr lhs, Expr rhs) {
		super(lhs, rhs);
		System.out.println(lhs + "       " + rhs + "              Add Class");
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new NumericType();
	}

	@Override
	public <T> T accept(AlgebricElementVisitor<T> visitor) {
		return visitor.visit(this);
	}

}