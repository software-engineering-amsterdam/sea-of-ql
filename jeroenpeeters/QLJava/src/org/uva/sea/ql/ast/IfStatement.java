package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.parser.ASTVisitor;

public class IfStatement extends Statement {

	private final Expression expression;
	private final CompoundStatement compoundStatement;
	
	public IfStatement(Expression expr, CompoundStatement compoundStatement) {
		this.expression = expr;
		this.compoundStatement = compoundStatement;
	}
	
	public Expression getExpression() {
		return expression;
	}

	public CompoundStatement getCompoundStatement() {
		return compoundStatement;
	}
	
	public void accept(ASTVisitor v){
		v.visit(this);
	}
	
}
