package org.uva.sea.ql.visitors.rendering;

import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.IntLiteral;
import org.uva.sea.ql.ast.expr.value.MoneyLiteral;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitors.ITypeVisitor;

class ValueInitializer implements ITypeVisitor<Value> {

	public static Value initializeValue(Type node) {
		ValueInitializer initialize = new ValueInitializer();
		return node.accept(initialize);
	}

	@Override
	public Value visit(BoolType node) {
		return new BoolLiteral(false);
	}

	@Override
	public Value visit(IntType node) {
		return new IntLiteral(0);
	}

	@Override
	public Value visit(MoneyType node) {
		return new MoneyLiteral(0.00);
	}

	@Override
	public Value visit(StringType node) {
		return new StringLiteral("");
	}

}
