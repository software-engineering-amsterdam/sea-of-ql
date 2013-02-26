package org.uva.sea.ql.ast.visitors;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.statements.ComputedValue;
import org.uva.sea.ql.ast.statements.Form;
import org.uva.sea.ql.ast.statements.IfStatement;
import org.uva.sea.ql.ast.statements.Question;

public class StatementVisitorToSetTypesOfIdentifiers implements StatementVisitor{
	
	private ExpressionVisitor expressionVisitor;
	
	public StatementVisitorToSetTypesOfIdentifiers(ExpressionVisitor expressionVisitor)	{
		this.expressionVisitor=expressionVisitor;
	}
		
	@Override
	public void visit(Form form) {		
		for(Statement statement : form.getStatements())	{
			statement.accept(this);
		}
	}

	@Override
	public void visit(Question question) {
	}

	@Override
	public void visit(ComputedValue computedValue) {
	}

	@Override
	public void visit(IfStatement ifStatement) {
		ifStatement.getExpression().accept(expressionVisitor);
	}
}
