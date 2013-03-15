package org.uva.sea.ql.checkers;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IStatementVisitor;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stmnt.Body;
import org.uva.sea.ql.ast.stmnt.ComputedQuestion;
import org.uva.sea.ql.ast.stmnt.IfStatement;
import org.uva.sea.ql.ast.stmnt.Question;
import org.uva.sea.ql.ast.stmnt.Statement;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.errors.QLError;

public class StatementChecker implements IStatementVisitor<Boolean> {

	private final Map<String, Type> typeEnvironment;
	private List<QLError> errors;

	public StatementChecker(Map<String, Type> typeEnvironment, List<QLError> errors) {

		this.typeEnvironment = typeEnvironment;
		this.errors = errors;
	}

	public List<QLError> getErrors() {
		return this.errors;
	}

	public static boolean check(Form form, Map<String, Type> typeEnvironment, List<QLError> errors) {

		StatementChecker stmntChecker = new StatementChecker(typeEnvironment, errors);

		return form.accept(stmntChecker);
	}

	@Override
	public Boolean visit(Form form) {

		boolean checkBody = form.getBody().accept(this);

		if (!checkBody) {
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit(Question question) {

		Ident qID = question.getID();

		if (typeEnvironment.containsKey(qID.getName())) {
			errors.add(new QLError("Duplicate questionID : " + qID.getName() + ""));
			return false;
		} else {
			typeEnvironment.put(qID.getName(), question.getType());
		}

		return true;
	}

	@Override
	public Boolean visit(ComputedQuestion computedQuestion) {

		Ident qID = computedQuestion.getID();
		Expr expr = computedQuestion.getExpr();

		if (typeEnvironment.containsKey(qID.getName())) {
			errors.add(new QLError("Duplicate questionID : " + qID.getName() + ""));
			return false;
		} else {
			typeEnvironment.put(qID.getName(), computedQuestion.getType());
		}

		if (!(computedQuestion.getType().isCompatibleTo(expr.isOfType(typeEnvironment)))) {
			errors.add(new QLError("Invalid expression in question " + computedQuestion.getID()
					+ ". Expected expression of type " + computedQuestion.getType() + ""));
			return false;
		}
		// call Expr Type Checker
		boolean checkExpr = ExprTypeChecker.check(expr, typeEnvironment, errors);

		if (!checkExpr) {
			errors.add(new QLError("Invalid expression in question " + computedQuestion.getID()
					+ ""));
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit(IfStatement ifStatement) {

		Expr expr = ifStatement.getExpr();

		boolean checkCondition = ExprTypeChecker.check(expr, typeEnvironment, errors);

		if (!checkCondition) {
			return false;
		}

		Type conditionType = expr.isOfType(typeEnvironment);

		if (!(conditionType.isCompatibleToBool())) {
			errors.add(new QLError("Expression in condition is of type"
					+ conditionType.getClass().getSimpleName() + ". Expected type Bool"));
			return false;
		}

		boolean checkBody = ifStatement.getBody().accept(this);

		if (!checkBody) {
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit(Body body) {

		List<Statement> statements = body.getStatements();
		boolean checkStatement = true;

		for (Statement statement : statements) {
			checkStatement = statement.accept(this);
			if (!checkStatement) {
				return false;
			}
		}
		return true;
	}

}
