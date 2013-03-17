package org.uva.sea.ql.ast.alg;

import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.AlgebricElementVisitor;

public class Neg extends Unary {

	public Neg(Expr value) {
		super(value);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new MoneyType();
	}

	@Override
	public <T> T accept(AlgebricElementVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
