package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.type.BooleanType;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.SymbolTable;

public class Not extends Unary {

	public Not(Expr arg) {
		super(arg);
	}

	@Override
	public String toString() {
		return "!";
	}
	
	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return new BooleanType();
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
