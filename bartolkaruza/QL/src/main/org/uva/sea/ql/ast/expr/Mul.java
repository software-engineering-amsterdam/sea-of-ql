package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.grouping.BinaryExpr;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.ast.expr.type.NumericType;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Mul extends BinaryExpr {

	private Type type = new NumericType();
	
	public Mul(int lineNumber, Expr lhs, Expr rhs) {
		super(lineNumber, lhs, rhs);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return type;
	}
}
