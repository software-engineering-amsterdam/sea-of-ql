package eu.karuza.ql.ast.expr;


import eu.karuza.ql.ast.Expr;
import eu.karuza.ql.ast.UnaryExpr;
import eu.karuza.ql.ast.type.BoolType;
import eu.karuza.ql.ast.type.Type;
import eu.karuza.ql.ast.value.Value;
import eu.karuza.ql.symbol.SymbolTable;
import eu.karuza.ql.visitor.ExpressionVisitor;

public class Not extends UnaryExpr {
	
	private static final long serialVersionUID = -2382460489252291408L;

	public Not(int lineNumber, Expr rhs) {
		super(lineNumber, rhs);
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
		return getLeftValue().not();
	}
}
