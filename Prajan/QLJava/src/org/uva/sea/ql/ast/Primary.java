package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.AlgebricElementVisitor;

public class Primary extends Expr {

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return null;
	}

	@Override
	public <T> T accept(AlgebricElementVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
