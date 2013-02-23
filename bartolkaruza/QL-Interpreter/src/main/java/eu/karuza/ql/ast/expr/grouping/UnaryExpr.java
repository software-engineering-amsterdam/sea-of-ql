package eu.karuza.ql.ast.expr.grouping;


import eu.karuza.ql.ast.expr.type.Type;
import eu.karuza.ql.ast.expr.value.Value;
import eu.karuza.ql.symbol.SymbolTable;


public abstract class UnaryExpr extends Expr {

	private static final long serialVersionUID = -7691090701019237207L;
	private Expr rhs;
	
	protected UnaryExpr(int lineNumber, Expr rhs) {
		super(lineNumber);
		this.rhs = rhs;
	}
	
	public Expr getRhs() {
		return rhs;
	}
	
	protected Value getLeftValue() {
		return rhs.evaluate();
	}
	
	@Override
	public Type getLeastUpperBoundsType(SymbolTable table) {
		return getRhs().typeOf(table);
	}
	
	@Override
	public boolean isCompatibleToType(Type type, SymbolTable table) {
		return type.isCompatibleTo(typeOf(table));
	}

}
