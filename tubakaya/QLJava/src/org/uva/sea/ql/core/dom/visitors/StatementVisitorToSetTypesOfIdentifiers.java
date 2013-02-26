package org.uva.sea.ql.core.dom.visitors;

import org.uva.sea.ql.core.dom.ExpressionVisitor;
import org.uva.sea.ql.core.dom.Statement;
import org.uva.sea.ql.core.dom.StatementVisitor;
import org.uva.sea.ql.core.dom.statements.ComputedValue;
import org.uva.sea.ql.core.dom.statements.Form;
import org.uva.sea.ql.core.dom.statements.IfStatement;
import org.uva.sea.ql.core.dom.statements.Question;

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
