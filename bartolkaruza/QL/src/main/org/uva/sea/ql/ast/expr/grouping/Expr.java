package org.uva.sea.ql.ast.expr.grouping;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.symbol.SymbolTable;

public abstract class Expr implements ASTNode {

	private int lineNumber;
	
	protected Expr(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public abstract Type typeOf(SymbolTable symbolTable);
}
