package eu.karuza.ql.ast.expr;


import eu.karuza.ql.ast.BinaryExpr;
import eu.karuza.ql.ast.Expr;
import eu.karuza.ql.ast.type.Type;
import eu.karuza.ql.ast.value.Value;
import eu.karuza.ql.symbol.SymbolTable;
import eu.karuza.ql.visitor.ExpressionVisitor;

public class Add extends BinaryExpr {

	private static final long serialVersionUID = 4193283036394216259L;

	public Add(int lineNumber, Expr lhs, Expr rhs) {
		super(lineNumber, lhs, rhs);
	}

	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return getLeastUpperBoundsType(symbolTable); 
	}

	@Override
	public void accept(ExpressionVisitor<?> visitor) {
		visitor.visit(this);
	}
	
	@Override
	public Value evaluate() {
		return getRightValue().add(getLeftValue());
	}
	
	@Override
	public boolean isCompatibleToType(Type type, SymbolTable table) {
		return super.isCompatibleToType(type, table);
	}

}
