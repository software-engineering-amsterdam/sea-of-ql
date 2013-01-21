package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.ast.expr.grouping.UnaryExpr;
import org.uva.sea.ql.ast.expr.type.NumericType;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.NodeVisitor;

public class Pos extends UnaryExpr {
	
	private Type type = new NumericType();

	public Pos(int lineNumber, Expr rhs) {
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
