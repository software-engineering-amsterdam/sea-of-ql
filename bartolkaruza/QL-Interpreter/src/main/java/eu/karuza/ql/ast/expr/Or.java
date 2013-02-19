package eu.karuza.ql.ast.expr;


import eu.karuza.ql.ast.expr.grouping.BinaryExpr;
import eu.karuza.ql.ast.expr.grouping.Expr;
import eu.karuza.ql.ast.expr.type.BoolType;
import eu.karuza.ql.ast.expr.type.Type;
import eu.karuza.ql.ast.expr.value.Value;
import eu.karuza.ql.symbol.SymbolTable;
import eu.karuza.ql.visitor.ExpressionVisitor;

public class Or extends BinaryExpr {
	
	private static final long serialVersionUID = 6085961202807774914L;

	public Or(int lineNumber, Expr lhs, Expr rhs) {
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
		return getRightValue().or(getLeftValue());
	}
}
