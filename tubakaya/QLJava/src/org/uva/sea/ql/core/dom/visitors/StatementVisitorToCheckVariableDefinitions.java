package org.uva.sea.ql.core.dom.visitors;

import java.util.ArrayList;
import java.util.List;
import org.uva.sea.ql.core.dom.ExpressionVisitor;
import org.uva.sea.ql.core.dom.*;
import org.uva.sea.ql.core.dom.statements.*;
import org.uva.sea.ql.parsers.exceptions.StatementNotValidException;

public class StatementVisitorToCheckVariableDefinitions implements StatementVisitor{

	private List<Identifier> identifierList;
	private List<StatementNotValidException> exceptions;
	private ExpressionVisitor expressionVisitor;
	
	public StatementVisitorToCheckVariableDefinitions(ExpressionVisitor expressionVisitor)	{
		this.identifierList = new ArrayList<Identifier>();
		this.exceptions = new ArrayList<StatementNotValidException>();
		this.expressionVisitor = expressionVisitor;
	}
	
	public List<StatementNotValidException> getErrors() {
		return exceptions;
	}	
	
	@Override
	public void visit(Form form) {		
		for(Statement statement : form.statements)	{
			statement.accept(this);
		}
	}

	@Override
	public void visit(Question question) {
		if(identifierWithSameNameAndTypeAlreadyDefined(question.identifier)){
			addExceptionInExceptionsList(question);
		}
		addIdentifierInIdentifiersList(question.identifier);
	}

	@Override
	public void visit(ComputedValue computedValue) {
		if(identifierWithSameNameAndTypeAlreadyDefined(computedValue.identifier)){
			addExceptionInExceptionsList(computedValue);
		}
		addIdentifierInIdentifiersList(computedValue.identifier);
	}

	@Override
	public void visit(IfStatement ifStatement) {
		ifStatement.getExpression().accept(expressionVisitor);

		for(Statement statement : ifStatement.getStatements())	{
			statement.accept(this);
		}
	}

	private boolean identifierWithSameNameAndTypeAlreadyDefined(Identifier identifier){
		boolean identifierWithSameNameAndTypeAlreadyDefined = false;
		
		for(Identifier definedIdentifier : identifierList){
			if(definedIdentifier.getName() == identifier.getName() 
				&& definedIdentifier.getType().getTypeName() == identifier.getType().getTypeName()){
				identifierWithSameNameAndTypeAlreadyDefined = true;
				break;
			}
		}
		
		return identifierWithSameNameAndTypeAlreadyDefined;
	}
	
	private void addExceptionInExceptionsList(Statement statement){
		this.exceptions.add(new StatementNotValidException(statement));
	}
	
	private boolean addIdentifierInIdentifiersList(Identifier identifier){
		return identifierList.add(identifier);
	}
}
