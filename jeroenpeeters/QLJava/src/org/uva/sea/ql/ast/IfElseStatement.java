package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Expression;

public class IfElseStatement extends IfStatement {

	private final Statement elseStatement;
	
	public IfElseStatement(Expression expr, Statement statement, Statement elseStatement) {
		super(expr, statement);
		this.elseStatement = elseStatement;
	}

	public Statement getElseStatement() {
		return elseStatement;
	}
	
	public void accept(ASTVisitor v){
		v.visit(this);
	}
	
}