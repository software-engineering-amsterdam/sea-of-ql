package eu.karuza.ql.ast.expr;


import eu.karuza.ql.ast.BinaryExpr;
import eu.karuza.ql.ast.Expr;
import eu.karuza.ql.ast.type.Type;
import eu.karuza.ql.ast.value.Value;
import eu.karuza.ql.symbol.SymbolTable;
import eu.karuza.ql.visitor.ExpressionVisitor;

public class Mul extends BinaryExpr {

	private static final long serialVersionUID = 442626064924039899L;
	
	public Mul(int lineNumber, Expr lhs, Expr rhs) {
		super(lineNumber, lhs, rhs);
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
		return getRightValue().mul(getLeftValue());
	}
}
