package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.IFormVisitor;
import org.uva.sea.ql.visitor.SymbolTable;

public abstract class Expr implements ASTNode {
	public abstract <T> T accept(IExpressionVisitor<T> visitor);
	public abstract Type typeOf(SymbolTable symbolTable);
	
	@Override
	public void accept(IFormVisitor visitor) {
	}
}
