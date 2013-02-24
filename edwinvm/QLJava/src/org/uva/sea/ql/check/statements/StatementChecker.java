package org.uva.sea.ql.check.statements;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.literal.Identifier;
import org.uva.sea.ql.ast.statements.FormStatement;
import org.uva.sea.ql.ast.statements.StatementBody;
import org.uva.sea.ql.ast.statements.conditions.ConditionBlock;
import org.uva.sea.ql.ast.statements.conditions.IfThenElseStatement;
import org.uva.sea.ql.ast.statements.conditions.IfThenStatement;
import org.uva.sea.ql.ast.statements.questions.AnswerableQuestion;
import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;
import org.uva.sea.ql.ast.statements.questions.Question;
import org.uva.sea.ql.ast.statements.questions.QuestionVariable;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.statementchecker.Visitor;
import org.uva.sea.ql.check.expressions.TypeChecker;
import org.uva.sea.ql.parser.TypeEnvironment;
import org.uva.sea.ql.parser.errors.ErrorMessages;
import org.uva.sea.ql.parser.errors.Message;

public class StatementChecker implements Visitor {
	
	private final TypeEnvironment _typeEnvironment;
	private final ErrorMessages _errorMessages;
	
	public StatementChecker(TypeEnvironment typeEnvironment, ErrorMessages messages) {
		_typeEnvironment = typeEnvironment;
		_errorMessages = messages;
	}
	
	public void check(FormStatement statement) { 
		statement.accept(this); 
	}

	@Override
	public void visit(IfThenStatement statement) {
		checkCondition(statement);
		checkBody(statement.getBody());
	}
	
	@Override
	public void visit(IfThenElseStatement statement) {
		checkCondition(statement);
		checkBody(statement.getBody());
		checkBody(statement.getElseBody());
	}

	@Override
	public void visit(AnswerableQuestion statement) {
		checkName(statement, statement.getType());
	}

	@Override
	public void visit(ComputedQuestion statement) {
		checkName(statement, statement.getExpression().typeOf(_typeEnvironment));
		checkExpression(statement.getExpression());
	}
	
	private void checkCondition(ConditionBlock statement) { checkExpression(statement.getCondition()); }
	private void checkExpression(Expression expression) {
		// Run expression through TypeChecker
		TypeChecker.check(expression, _typeEnvironment, _errorMessages);
	}
	
	private void checkName(Question statement, Type type) {
		checkQuestionCompatibility(statement.getQuestionVariable(), type);
	}
	
	private void checkBody(StatementBody body) {
		for (FormStatement statement: body.getStatements()) {
			check(statement);
		}
	}
	
	private void checkQuestionCompatibility(QuestionVariable questionVariable, Type type) {
		storeQuestionVariable(questionVariable, type);
		Type questionVariableType = getVariableTypeFor(questionVariable.getVariable());
		if (!type.isCompatibleTo(questionVariableType)) {
			addError(questionVariable.getVariable());
		}
	}
	
	private Type getVariableTypeFor(Identifier variable) {
		return variable.typeOf(_typeEnvironment);
	}

	private void storeQuestionVariable(QuestionVariable variable, Type type) {
		_typeEnvironment.add(variable.getVariable(), type);
	}
	
	private void addError(Identifier identifier) {
		_errorMessages.add(new Message("Invalid type for identifier " + identifier.getValue()));
	}
	
}