package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.visitor.IStatementVisitor;

public class StatementElement extends Statement{
	private Expr expression;
	private Block ifBlock, elseBlock;
	
	public StatementElement (Expr expression, Block ifBlock){
		this.expression=expression;
		this.ifBlock = ifBlock;
	}
	
	public StatementElement (Expr expression, Block ifBlock, Block elseBlock){
		this.expression=expression;
		this.ifBlock = ifBlock;
		this.elseBlock = elseBlock;
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	public Block getIfBlock() {
		return ifBlock;
	}
	
	public Block getElseBlock() {
		return elseBlock;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);	
	}
}
