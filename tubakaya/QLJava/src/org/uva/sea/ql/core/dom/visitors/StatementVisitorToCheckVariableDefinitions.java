package org.uva.sea.ql.core.dom.visitors;

import java.util.ArrayList;
import java.util.List;
import org.uva.sea.ql.core.dom.ExpressionVisitor;
import org.uva.sea.ql.core.dom.*;
import org.uva.sea.ql.core.dom.statements.*;
import org.uva.sea.ql.parsers.exceptions.StatementNotValidException;

public class StatementVisitorToCheckVariableDefinitions implements StatementVisitor{

	private List<Variable> variableList;
	private List<StatementNotValidException> errors;
	private ExpressionVisitor expressionVisitor;
	
	public StatementVisitorToCheckVariableDefinitions(ExpressionVisitor expressionVisitor)	{
		this.variableList = new ArrayList<Variable>();
		this.errors = new ArrayList<StatementNotValidException>();
		this.expressionVisitor = expressionVisitor;
	}
	
	public List<StatementNotValidException> getErrors() {
		return errors;
	}	
	
	@Override
	public void visit(Form form) {		
		for(Statement statement : form.statements)	{
			statement.accept(this);
		}
	}

	@Override
	public void visit(Question question) {
		if(VariableWithSameNameAndTypeAlreadyDefined(question.variable)){
			AddErrorInTheErrorList(question);
		}
		AddVariableInTheList(question.variable);
	}

	@Override
	public void visit(ComputedValue computedValue) {
		if(VariableWithSameNameAndTypeAlreadyDefined(computedValue.variable)){
			AddErrorInTheErrorList(computedValue);
		}
		AddVariableInTheList(computedValue.variable);
	}

	@Override
	public void visit(IfStatement ifStatement) {
		ifStatement.getExpression().accept(expressionVisitor);

		for(Statement statement : ifStatement.getStatements())	{
			statement.accept(this);
		}
	}

	private boolean VariableWithSameNameAndTypeAlreadyDefined(Variable variable){
		boolean variableWithSameNameAndTypeAlreadyDefined = false;
		
		for(Variable definedVariable : variableList){
			if(definedVariable.identifier.getName() == variable.identifier.getName() 
				&& definedVariable.typeDeclaration.getTypeName() == variable.typeDeclaration.getTypeName()){
				variableWithSameNameAndTypeAlreadyDefined = true;
				break;
			}
		}
		
		return variableWithSameNameAndTypeAlreadyDefined;
	}
	
	private void AddErrorInTheErrorList(Statement statement){
		this.errors.add(new StatementNotValidException(statement));
	}
	
	private boolean AddVariableInTheList(Variable variable){
		return variableList.add(variable);
	}
}
