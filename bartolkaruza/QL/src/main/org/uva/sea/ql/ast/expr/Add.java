package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.grouping.BinaryExpr;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.ast.expr.type.NumericType;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.NodeVisitor;

public class Add extends BinaryExpr {

	private Type type = new NumericType();
	
	public Add(int lineNumber, Expr lhs, Expr rhs) {
		super(lineNumber, lhs, rhs);
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
