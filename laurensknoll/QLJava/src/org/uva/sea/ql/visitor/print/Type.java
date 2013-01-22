package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.String;

public class Type implements org.uva.sea.ql.visitor.Type<Boolean> {

	@Override
	public Boolean visit(Bool bool) {
		System.out.println("Visiting Bool AnswerType");

		return true;
	}

	@Override
	public Boolean visit(Int intType) {
		System.out.println("Visiting Int AnswerType");

		return true;
	}

	@Override
	public Boolean visit(Money money) {
		System.out.println("Visiting Money AnswerType");

		return true;
	}

	@Override
	public Boolean visit(String string) {
		System.out.println("Visiting String AnswerType");

		return true;
	}

}
