package org.uva.sea.ql.ast.visitors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.parsers.exceptions.StatementNotValidException;

public class StatementVisitorToCheckIdentifierDefinitions implements StatementVisitor{

	private List<Identifier> identifierList;
	private List<StatementNotValidException> exceptions;
	
	public StatementVisitorToCheckIdentifierDefinitions()	{
		this.identifierList = new ArrayList<Identifier>();
		this.exceptions = new ArrayList<StatementNotValidException>();
	}
	
	public List<StatementNotValidException> getExceptions() {
		return exceptions;
	}	
	
	public List<Identifier> getIdentifierList() {
		return identifierList;
	}
	
	@Override
	public void visit(Form form) {		
		for(Statement statement : form.getStatements())	{
			statement.accept(this);
		}
	}

	@Override
	public void visit(Question question) {
		if(identifierWithSameNameAndTypeAlreadyDefined(question.getIdentifier())){
			addExceptionInExceptionsList(question);
		}
		addIdentifierInIdentifiersList(question.getIdentifier());
	}

	@Override
	public void visit(ComputedValue computedValue) {
		if(identifierWithSameNameAndTypeAlreadyDefined(computedValue.getIdentifier())){
			addExceptionInExceptionsList(computedValue);
		}
		addIdentifierInIdentifiersList(computedValue.getIdentifier());
	}

	@Override
	public void visit(IfStatement ifStatement) {

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
