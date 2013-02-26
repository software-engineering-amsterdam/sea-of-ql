package org.uva.sea.ql.visitor.semantic;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.String;
import org.uva.sea.ql.visitor.IType;

public class Numeric implements IType<Boolean> {

	@Override
	public Boolean visit(Bool bool) {
		return false;
	}

	@Override
	public Boolean visit(Int intType) {
		return true;
	}

	@Override
	public Boolean visit(Money money) {
		return true;
	}

	@Override
	public Boolean visit(String string) {
		return false;
	}

	@Override
	public Boolean visit(org.uva.sea.ql.ast.type.Numeric numeric) {
		return true;
	}

}
