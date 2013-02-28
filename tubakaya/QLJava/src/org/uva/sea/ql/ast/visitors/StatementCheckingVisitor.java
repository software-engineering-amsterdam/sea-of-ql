package org.uva.sea.ql.ast.visitors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.statements.ComputedValue;
import org.uva.sea.ql.ast.statements.Form;
import org.uva.sea.ql.ast.statements.IfStatement;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parsers.exceptions.ExpressionNotValidException;
import org.uva.sea.ql.parsers.exceptions.IdentifierNotDefinedException;
import org.uva.sea.ql.parsers.exceptions.QLException;

public class StatementCheckingVisitor implements StatementVisitor {

	private Map<Identifier, Type> identifierTypeMap;
	private List<QLException> exceptions;
	private ExpressionTypeCheckingVisitor expressionTypeCheckingVisitor;
	
	public StatementCheckingVisitor() {
		identifierTypeMap = new HashMap<Identifier, Type>();
		exceptions = new ArrayList<QLException>();
		this.expressionTypeCheckingVisitor = new ExpressionTypeCheckingVisitor(
				identifierTypeMap);
	}

	public List<QLException> getExceptions() {
		return exceptions;
	}

	public Map<Identifier, Type> getIdentifierTypeMap() {
		return identifierTypeMap;
	}

	@Override
	public void visit(Form form) {
		for (Statement statement : form.getStatements()) {
			statement.accept(this);
		}
	}

	@Override
	public void visit(Question question) {

		Type type = question.getType();
		Identifier identifier = question.getIdentifier();

		checkIdentifierDefinition(identifier, type);
	}

	@Override
	public void visit(ComputedValue computedValue) {

		Expression expression = computedValue.getExpression();
		Type type = computedValue.getType();
		Identifier identifier = computedValue.getIdentifier();

		checkIdentifierDefinition(identifier, type);
		checkExpressionValidation(expression, type);
	}

	@Override
	public void visit(IfStatement ifStatement) {

		Expression expression = ifStatement.getExpression();
		BooleanType booleanType = new BooleanType();

		checkExpressionValidation(expression, booleanType);

		List<Statement> statements = ifStatement.getStatements();

		for (Statement statement : statements) {
			statement.accept(this);
		}
	}

	private void checkExpressionValidation(Expression expression, Type type) {
		expression.accept(getExpressionCheckingVisitor());
	
		if (!typeOfExpressionIsCompatible(expression, type)) {
			addExceptionInExceptionsList(expression);
		}
	}

	private void checkIdentifierDefinition(Identifier identifier, Type type) {
		if (identifierExistsInIdentifierTypeMap(identifier)) {
			addExceptionInExceptionsList(identifier);
		}
		addIdentifierAndTypeInMap(identifier, type);
	}

	private Boolean identifierExistsInIdentifierTypeMap(Identifier identifier) {
		return identifierTypeMap.containsKey(identifier);
	}

	private void addIdentifierAndTypeInMap(Identifier identifier, Type type) {
		identifierTypeMap.put(identifier, type);
	}

	private void addExceptionInExceptionsList(Identifier identifier) {
		this.exceptions.add(new IdentifierNotDefinedException(identifier));
	}

	private void addExceptionInExceptionsList(Expression expression) {
		this.exceptions.add(new ExpressionNotValidException(expression));
	}

	private ExpressionCheckingVisitor getExpressionCheckingVisitor() {
		return new ExpressionCheckingVisitor(identifierTypeMap, exceptions);
	}

	private boolean typeOfExpressionIsCompatible(Expression expression,
			Type compatibleType) {
		
		Type type = expression.accept(expressionTypeCheckingVisitor);

		return type.isCompatibleTo(compatibleType);
	}
}
