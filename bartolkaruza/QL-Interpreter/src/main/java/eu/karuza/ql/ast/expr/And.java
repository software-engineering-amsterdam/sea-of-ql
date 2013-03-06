package eu.karuza.ql.ast.expr;


import eu.karuza.ql.ast.BinaryExpr;
import eu.karuza.ql.ast.Expr;
import eu.karuza.ql.ast.type.BoolType;
import eu.karuza.ql.ast.type.Type;
import eu.karuza.ql.ast.value.Value;
import eu.karuza.ql.symbol.SymbolTable;
import eu.karuza.ql.visitor.ExpressionVisitor;

public class And extends BinaryExpr {
	
	private static final long serialVersionUID = -2787990699367940010L;

	public And(int lineNumber, Expr lhs, Expr rhs) {
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
		return getRightValue().and(getLeftValue());
	}

}
