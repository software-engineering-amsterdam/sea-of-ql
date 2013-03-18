package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.alg.Bool;
import org.uva.sea.ql.ast.alg.Int;
import org.uva.sea.ql.ast.alg.Money;
import org.uva.sea.ql.ast.alg.Str;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.NumericType;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.gen.TypeError;

public class TypeDefaultValue implements TypeVisitor<Value> {

	@Override
	public Value visit(BoolType type) {
		return new Bool(false);
	}

	@Override
	public Value visit(StrType type) {
		return new Str("");
	}

	@Override
	public Value visit(MoneyType type) {
		return new Money(0.0);
	}

	@Override
	public Value visit(IntType type) {
		return new Int(0);
	}

	@Override
	public Value visit(NumericType type) {
		throw new UnsupportedOperationException("unsupported operation");
	}

	@Override
	public Value visit(TypeError type) {
		throw new UnsupportedOperationException("unsupported operation");
	}

}
