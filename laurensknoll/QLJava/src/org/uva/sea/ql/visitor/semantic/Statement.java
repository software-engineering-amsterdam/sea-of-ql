package org.uva.sea.ql.visitor.semantic;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.statement.AbstractStatement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.IExpression;
import org.uva.sea.ql.visitor.IStatement;
import org.uva.sea.ql.visitor.IType;

public class Statement implements IStatement<ValidationResult> {

	private final Environment environment;

	public Statement(Environment context) {
		this.environment = context;
	}

	@Override
	public ValidationResult visit(Block block) {
		Environment newBlockContext = new Environment(this.environment);
		IStatement<ValidationResult> statementVisitor = new Statement(
				newBlockContext);

		ValidationResult result = new ValidationResult();
		for (AbstractStatement statement : block.getStatements()) {
			result.addValidationResult(statement.accept(statementVisitor));
		}

		return result;
	}

	@Override
	public ValidationResult visit(ComputedQuestion computedQuestion) {
		ValidationResult result = computedQuestion.getQuestion().accept(this);

		IExpression<ValidationResult> expressionVisitor = new Expression(
				this.environment);
		result.addValidationResult(computedQuestion.getComputation().accept(
				expressionVisitor));

		return result;
	}

	@Override
	public ValidationResult visit(If ifStatement) {
		IExpression<ValidationResult> expressionVisitor = new Expression(
				this.environment);
		ValidationResult result = ifStatement.getCondition().accept(
				expressionVisitor);

		result.addValidationResult(ifStatement.getTruePath().accept(this));

		return result;
	}

	@Override
	public ValidationResult visit(Question question) {
		ValidationResult result = new ValidationResult();

		Ident id = question.getIdent();
		AbstractType type = question.getType();

		if (!this.environment.exists(id)) {
			this.environment.declare(id, type);
		} else {
			String identNotUnique = String.format(
					"Ident \"%s\" is already defined.", id.getName());
			result.addError(identNotUnique);
		}

		IExpression<ValidationResult> expressionVisitor = new Expression(
				this.environment);
		result.addValidationResult(id.accept(expressionVisitor));

		IType<ValidationResult> typeVisitor = new Type();
		result.addValidationResult(type.accept(typeVisitor));

		result.addValidationResult(question.getQuestion().accept(
				expressionVisitor));

		return result;
	}

}
