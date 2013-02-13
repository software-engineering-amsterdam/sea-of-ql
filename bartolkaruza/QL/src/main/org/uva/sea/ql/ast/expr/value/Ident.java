package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Ident extends Expr {

	private static final long serialVersionUID = -4211732920881892762L;
	private final String name;
	private Expr expr;

	public Ident(int lineNumber, String name) {
		super(lineNumber);
		this.name = name;
	}

	@Override
	public void accept(ExpressionVisitor<?> visitor) {
		visitor.visit(this);
	}

	public String getName() {
		return name;
	}

	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return symbolTable.getSymbol(name).getType(symbolTable);
	}
	
	@Override
	public Value evaluate() {
		return expr.evaluate();
	}

	@Override
	protected Type getLeastUpperBoundsType(SymbolTable table) {
		return expr.typeOf(table);
	}

	@Override
	public boolean isCompatibleToType(Type type, SymbolTable table) {
		return expr.isCompatibleToType(type, table);
	}

}
