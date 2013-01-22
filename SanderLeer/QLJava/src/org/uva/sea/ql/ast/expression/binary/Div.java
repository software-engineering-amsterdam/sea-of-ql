package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.Visitor;
import org.uva.sea.ql.ast.datatype.Datatype;
import org.uva.sea.ql.ast.datatype.IntegerType;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.typechecker.SymbolTable;

public class Div extends BinaryExpression {
	public Div(Expression lhs, Expression rhs) {
		super(lhs, rhs);
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
