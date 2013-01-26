package org.uva.sea.ql.visitor.semantic;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.statement.AbstractStatement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.type.AbstractType;

public class Statement implements org.uva.sea.ql.visitor.Statement<Boolean> {

	private final Environment environment;

	private final List<String> errors;

	public Statement(Environment context) {
		this.environment = context;
		this.errors = new ArrayList<String>();
	}

	@Override
	public Boolean visit(Block block) {
		Boolean isValid = true;

		Environment newBlockContext = new Environment(this.environment);
		Statement statementVisitor = new Statement(newBlockContext);
		for (AbstractStatement statement : block.getStatements()) {
			isValid &= statement.accept(statementVisitor);
		}

		if (!isValid) {
			this.errors.addAll(statementVisitor.getErrors());
		}

		return isValid;
	}

	@Override
	public Boolean visit(ComputedQuestion computedQuestion) {
		Boolean isQuestionValid = computedQuestion.getQuestion().accept(this);

		Expression expressionVisitor = new Expression(this.environment);
		Boolean isComputeExpressionValid = computedQuestion
				.getComputeExpression().accept(expressionVisitor);

		if (!isComputeExpressionValid) {
			this.errors.addAll(expressionVisitor.getErrors());
		}

		return isQuestionValid && isComputeExpressionValid;
	}

	@Override
	public Boolean visit(If ifStatement) {
		Expression expressionVisitor = new Expression(this.environment);
		Boolean isConditionValid = ifStatement.getCondition().accept(
				expressionVisitor);
		if (!isConditionValid) {
			this.errors.addAll(expressionVisitor.getErrors());
		}

		Boolean isTruePathValid = ifStatement.getTruePath().accept(this);

		return isConditionValid && isTruePathValid;
	}

	@Override
	public Boolean visit(Question question) {
		Ident id = question.getIdent();
		AbstractType type = question.getType();

		Boolean isIdentDeclared = false;
		if (!this.environment.exists(id)) {
			this.environment.declare(id, type);
			isIdentDeclared = true;
		} else {
			String identNotUnique = String.format(
					"Ident \"%s\" is already defined.", id.getName());
			this.errors.add(identNotUnique);
		}

		Expression expressionVisitor = new Expression(this.environment);
		Boolean isIdentValid = id.accept(expressionVisitor);
		if (!isIdentValid) {
			this.errors.addAll(expressionVisitor.getErrors());
		}

		Type typeVisitor = new Type();
		Boolean isTypeValid = type.accept(typeVisitor);

		Boolean isDescriptionValid = question.getQuestion().accept(
				expressionVisitor);

		return isIdentDeclared && isIdentValid && isTypeValid
				&& isDescriptionValid;
	}

	public List<String> getErrors() {
		return this.errors;
	}

}
