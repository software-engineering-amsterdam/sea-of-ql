package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.Visitor;
import org.uva.sea.ql.ast.datatype.BooleanType;
import org.uva.sea.ql.ast.datatype.Datatype;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.typechecker.SymbolTable;

public class Or extends BinaryExpression {
	public Or(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Datatype typeOf(SymbolTable symbols) {
		return new BooleanType();
	}
}
