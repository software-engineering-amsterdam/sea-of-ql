package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.ast.expr.grouping.ValueExpr;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Ident extends ValueExpr {

	private final String name;

	public Ident(int lineNumber, String name) {
		super(lineNumber);
		this.name = name;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	public String getName() {
		return name;
	}

	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return symbolTable.getSymbol(name).getVariable().typeOf(symbolTable);
	}

}
