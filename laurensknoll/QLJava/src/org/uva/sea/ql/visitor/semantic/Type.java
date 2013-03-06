package org.uva.sea.ql.visitor.semantic;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.String;
import org.uva.sea.ql.visitor.IType;

public class Type implements IType<ValidationResult> {

	@Override
	public ValidationResult visit(Bool bool) {
		return new ValidationResult();
	}

	@Override
	public ValidationResult visit(Int intType) {
		return new ValidationResult();
	}

	@Override
	public ValidationResult visit(Money money) {
		return new ValidationResult();
	}

	@Override
	public ValidationResult visit(String string) {
		return new ValidationResult();
	}

	@Override
	public ValidationResult visit(Numeric numeric) {
		return new ValidationResult();
	}

}
