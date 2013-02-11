package org.uva.sea.ql.visitor.eval;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.String;
import org.uva.sea.ql.visitor.IType;
import org.uva.sea.ql.visitor.eval.ui.Widget;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Type implements IType<Widget> {

	@Override
	public Widget visit(Bool bool) {
		return new org.uva.sea.ql.visitor.eval.ui.Bool();
	}

	@Override
	public Widget visit(Int intType) {
		return new org.uva.sea.ql.visitor.eval.ui.Int();
	}

	@Override
	public Widget visit(Money money) {
		return new org.uva.sea.ql.visitor.eval.ui.Money();
	}

	@Override
	public Widget visit(String string) {
		return new org.uva.sea.ql.visitor.eval.ui.Int();
	}

	@Override
	public Widget visit(org.uva.sea.ql.ast.type.Form form) {
		// TODO: Remove this visitor method.
		return null;
	}

	@Override
	public Widget visit(Numeric numeric) {
		// TODO: Will this ever be called?
		throw new NotImplementedException();
	}

}
