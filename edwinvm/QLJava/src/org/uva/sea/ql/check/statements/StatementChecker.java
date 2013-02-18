package org.uva.sea.ql.check.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.FormStatement;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.statements.ConditionBlock;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.statements.questions.AnswerableQuestion;
import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;
import org.uva.sea.ql.ast.visitors.statementchecker.Visitor;
import org.uva.sea.ql.check.expressions.TypeChecker;
import org.uva.sea.ql.parser.ErrorMessages;
import org.uva.sea.ql.parser.SupportedTypes;

public class StatementChecker implements Visitor {
	
	private final SupportedTypes _supportedTypes;
	private final ErrorMessages _errorMessages;
	
	private StatementChecker(SupportedTypes supportedTypes, ErrorMessages messages) {
		_supportedTypes = supportedTypes;
		_errorMessages = messages;
	}
	
	public static void check(FormStatement statement, SupportedTypes supportedTypes, ErrorMessages errors) {
		StatementChecker statementChecker = new StatementChecker(supportedTypes, errors);
		statement.accept(statementChecker);
	}

	@Override
	public void visit(ConditionBlock statement) {
		checkCondition(statement);
		statement.getIfBody().accept(this);
	}

	@Override
	public void visit(AnswerableQuestion statement) {
		checkName(statement, statement.getType());
	}

	@Override
	public void visit(ComputedQuestion statement) {
		checkName(statement, statement.getExpression().typeOf(_supportedTypes));
		checkExpr(statement.getExpression());
	}
	
	private void checkCondition(ConditionBlock statement) {
		checkExpr(statement.getExpr());
	}

	private void checkExpr(Expr expr) {
		// Run expression through TypeChecker
		TypeChecker.check(expr, _supportedTypes, _errorMessages);
	}
	
	private void checkName(Question statement, Type type) {
		Ident questionVariable = statement.getVariable();
		storeQuestionVariable(questionVariable, type);
		if (!type.isCompatibleTo(questionVariable.typeOf(_supportedTypes))) {
			_errorMessages.add("Invalid type for identifier " + questionVariable.getValue().toString());
		}
	}
	
	private void storeQuestionVariable(Ident questionVariable, Type type) {
		if (!_supportedTypes.contains(questionVariable)) {
			_supportedTypes.add(questionVariable.toString(), type);
		}
	}
	
}