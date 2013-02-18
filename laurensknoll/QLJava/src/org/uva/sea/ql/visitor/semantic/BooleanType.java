package org.uva.sea.ql.visitor.semantic;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.String;
import org.uva.sea.ql.visitor.IType;

public class BooleanType implements IType<Boolean> {

	@Override
	public Boolean visit(Bool bool) {
		return true;
	}

	@Override
	public Boolean visit(Int intType) {
		return false;
	}

	@Override
	public Boolean visit(Money money) {
		return false;
	}

	@Override
	public Boolean visit(String string) {
		return false;
	}

	@Override
	public Boolean visit(Numeric numeric) {
		return false;
	}

}
