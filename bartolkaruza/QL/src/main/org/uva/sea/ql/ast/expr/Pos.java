package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.ast.expr.grouping.UnaryExpr;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Pos extends UnaryExpr {
	
	private static final long serialVersionUID = -4584710815708330035L;

	public Pos(int lineNumber, Expr rhs) {
		super(lineNumber, rhs);
	}

	@Override
	public void accept(ExpressionVisitor<?> visitor) {
		visitor.visit(this);
	}
	
	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return getLeastUpperBoundsType(symbolTable);
	}
	
	@Override
	public Value evaluate() {
		return getLeftValue().pos();
	}

}
