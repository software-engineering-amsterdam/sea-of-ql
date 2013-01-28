package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.visitor.IType;

public class Type implements IType<String> {

	@Override
	public String visit(Bool bool) {
		return "Boolean";
	}

	@Override
	public String visit(Int intType) {
		return "Integer";
	}

	@Override
	public String visit(Money money) {
		return "Money";
	}

	@Override
	public String visit(org.uva.sea.ql.ast.type.String string) {
		return "String";
	}

	@Override
	public String visit(org.uva.sea.ql.ast.type.Form form) {
		return "Form";
	}

	@Override
	public String visit(Numeric numeric) {
		return "Numeric";
	}

}
