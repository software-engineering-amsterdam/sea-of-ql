package org.uva.sea.ql.ast.expression.unary;

import org.uva.sea.ql.ast.Visitor;
import org.uva.sea.ql.ast.datatype.Datatype;
import org.uva.sea.ql.ast.datatype.IntegerType;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.typechecker.SymbolTable;

public class Neg extends UnaryExpression {
	public Neg(Expression operand) {
		super(operand);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Datatype typeOf(SymbolTable symbols) {
		return new IntegerType();
	}
}
