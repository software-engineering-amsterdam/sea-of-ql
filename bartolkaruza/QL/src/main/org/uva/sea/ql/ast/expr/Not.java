package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.ast.expr.grouping.UnaryExpr;
import org.uva.sea.ql.ast.expr.type.BoolType;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.NodeVisitor;

public class Not extends UnaryExpr {
	
	private Type type = new BoolType();

	public Not(int lineNumber, Expr rhs) {
		super(lineNumber, rhs);
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return type;
	}
}
