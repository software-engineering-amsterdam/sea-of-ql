package eu.karuza.ql.ast;


import eu.karuza.ql.ast.type.Type;
import eu.karuza.ql.ast.value.Value;
import eu.karuza.ql.symbol.SymbolTable;

public abstract class BinaryExpr extends Expr {
	
	private static final long serialVersionUID = 3686731488734441828L;
	private Expr lhs;
	private Expr rhs;
	
	protected BinaryExpr(int lineNumber, Expr lhs, Expr rhs) {
		super(lineNumber);
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public Expr getLhs() {
		return lhs;
	}
	
	public Expr getRhs() {
		return rhs;
	}
	
	protected Value getLeftValue() {
		return lhs.evaluate();
	}
	
	protected Value getRightValue() {
		return rhs.evaluate();
	}
	
	@Override
	public Type getLeastUpperBoundsType(SymbolTable table) {
		Type lht = getLhs().typeOf(table);
		Type rht = getRhs().typeOf(table);
		return lht.leastUpperBound(rht);
	}
	
	@Override
	public boolean isCompatibleToType(Type type, SymbolTable table) {
		return type.isCompatibleTo(typeOf(table));
	}

}
