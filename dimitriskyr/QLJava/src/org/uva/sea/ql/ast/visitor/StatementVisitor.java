package org.uva.sea.ql.ast.visitor;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.ComQuestion;
import org.uva.sea.ql.ast.statements.IfThen;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.QuestionElement;
import org.uva.sea.ql.ast.statements.SimpleQuestion;
import org.uva.sea.ql.ast.statements.StatementElement;
import org.uva.sea.ql.ast.values.Ident;

public class StatementVisitor implements IStatementVisitor {

	private final Map<String, Type> typeEnv;
	private final List<String> errormessages;

	public StatementVisitor(Map<String, Type> tenv, List<String> messages) {
		this.typeEnv = tenv;
		this.errormessages = messages;
	}

	public void getErrormessages(String errors) {
		this.errormessages.add(errors);
	}

	@Override
	public void visit(Form form) {

		form.getBlock().accept(this);
	}

	@Override
	public void visit(Block block) {
		for (Statement BodyPart : block.getBody()) {
			BodyPart.accept(this);
		}
	}

	@Override
	public void visit(IfThen ifThen) {
		checkCondition(ifThen);
		ifThen.getIfBlock().accept(this);
	}

	@Override
	public void visit(IfThenElse ifThenElse) {
		checkCondition(ifThenElse);
		ifThenElse.getIfBlock().accept(this);
		ifThenElse.getElseBlock().accept(this);
	}

	@Override
	public void visit(SimpleQuestion simpleQuestion) {
		checkName(simpleQuestion, simpleQuestion.getType());
	}

	@Override
	public void visit(ComQuestion comQuestion) {
		checkName(comQuestion, comQuestion.getExpression().typeOf(typeEnv));
		checkExpr(comQuestion, comQuestion.getExpression());
	}

	private void checkName(QuestionElement question, Type type) {
		Ident questionId = question.getIdent();
		Type questionType = type;
		if (typeEnv.containsKey(questionId)) {
			errormessages.add("The name" + questionId
					+ "is invalid because it has already been declared");
		}
		typeEnv.put(questionId.getValue(), questionType);
	}

	private void checkExpr(QuestionElement comQuestions, Expr expression) {
		Type questionType = comQuestions.getType();
		Type expressionType = expression.typeOf(typeEnv);
		CheckExpr.check(expression, typeEnv, errormessages);

		if (!(questionType.isCompatibleTo(expressionType))) {
			errormessages.add("Error. The type of the question(" + questionType
					+ ") is different than the type of the expression("
					+ expressionType + ")");
		}
	}

	private void checkCondition(StatementElement statement) {
		Expr expr = statement.getCondition();
		CheckExpr.check(expr, typeEnv, errormessages);
		if (!(expr.typeOf(typeEnv).isCompatibleToBoolean())) {
			errormessages.add("Wrong type (" + expr.typeOf(typeEnv)
					+ "). The condition should be of type Boolean");
		}
	}
}
