package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.ASTVisitor;

public class IfStatement extends Statement {

	private final Expression expression;
	private final Statement statement;
	
	public IfStatement(Expression expr, Statement statement) {
		this.expression = expr;
		this.statement = statement;
	}
	
	public Expression getExpression() {
		return expression;
	}

	public Statement getStatement() {
		return statement;
	}

	public void accept(ASTVisitor v){
		v.visit(this);
	}
	
}
