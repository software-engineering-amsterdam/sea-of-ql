package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.statement.AbstractStatement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.visitor.IExpression;
import org.uva.sea.ql.visitor.IStatement;
import org.uva.sea.ql.visitor.IType;

public class Statement implements IStatement<String> {

	private final Environment environment;

	public Statement(Environment env) {
		this.environment = env;
	}

	@Override
	public String visit(Block block) {
		StringBuilder statements = new StringBuilder();
		statements.append(this.environment.getIndent());
		statements.append("{");
		statements.append(System.getProperty("line.separator"));

		Environment newBlockContext = new Environment(this.environment);
		IStatement<String> statementVisitor = new Statement(newBlockContext);

		for (AbstractStatement statement : block.getStatements()) {
			statements.append(statement.accept(statementVisitor));
			statements.append(System.getProperty("line.separator"));
		}

		statements.append(this.environment.getIndent());
		statements.append("}");

		return statements.toString();
	}

	@Override
	public String visit(ComputedQuestion computedQuestion) {
		String question = computedQuestion.getQuestion().accept(this);

		IExpression<String> expressionVisitor = new Expression();
		String expr = computedQuestion.getComputation().accept(
				expressionVisitor);

		return String.format("%s %s", question, expr);
	}

	@Override
	public String visit(If ifStatement) {
		StringBuilder sb = new StringBuilder();
		sb.append(System.getProperty("line.separator"));

		sb.append(this.environment.getIndent());

		sb.append("if (");

		IExpression<String> expressionVisitor = new Expression();
		String condition = ifStatement.getCondition().accept(expressionVisitor);
		sb.append(condition);

		sb.append(")");

		sb.append(System.getProperty("line.separator"));

		String statement = ifStatement.getTruePath().accept(this);
		sb.append(statement);

		return sb.toString();
	}

	@Override
	public String visit(Question question) {
		IExpression<String> expressionVisitor = new Expression();
		String ident = question.getIdent().accept(expressionVisitor);
		String descr = question.getQuestion().accept(expressionVisitor);

		IType<String> typeVisitor = new Type();
		String answerType = question.getType().accept(typeVisitor);

		return String.format("%s%s: %s %s", this.environment.getIndent(),
				ident, descr, answerType);
	}
}
