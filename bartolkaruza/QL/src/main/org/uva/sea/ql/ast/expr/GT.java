package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.grouping.BinaryExpr;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.ast.expr.type.BoolType;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class GT extends BinaryExpr {

	private static final long serialVersionUID = -797364629188407797L;
	
	public GT(int lineNumber, Expr lhs, Expr rhs) {
		super(lineNumber, lhs, rhs);
	}

	@Override
	public void accept(ExpressionVisitor<?> visitor) {
		visitor.visit(this);
	}
	
	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return new BoolType();
	}
	
	@Override
	public Value evaluate() {
		return getRightValue().gt(getLeftValue());
	}

}
