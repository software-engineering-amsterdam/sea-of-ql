package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.IStatementVisitor;
import org.uva.sea.ql.ast.expressions.Expression;

public class If extends Statement {

	private final Statement ifStatement;
	private final Statement elseStatement;
	private final Expression expression;
	
	public If(ICodeLocationInformation info, Expression expression, Statement ifStatement, Statement elseStatement) {
		super(info);
		this.expression = expression;
		this.ifStatement = ifStatement;
		this.elseStatement = elseStatement;
	}
	
	public If(ICodeLocationInformation info, Expression expression, Statement ifStatement) {
		super(info);
		this.expression = expression;
		this.ifStatement = ifStatement;
		this.elseStatement = null;
	}

	public Expression getExpression() {
		return expression;
	}
	
	public Statement getIfStatement() {
		return ifStatement;
	}
	
	public Statement getElseStatement() {
		return elseStatement;
	}
	
	@Override
	public void accept(IStatementVisitor visitor)  {
		visitor.visit(this);
	}
	
}
