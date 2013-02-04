package org.uva.sea.ql.visitor;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.stmt.IfThen;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.Statement;
import org.uva.sea.ql.ast.stmt.question.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.question.NormalQuestion;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.message.Error;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.message.Warning;

/*
 * This FormVisitor checks for:
 * 	- duplicate question ids
 *  - validity of expressions
 *  	- only allow boolean expressions in if condition
 *  	- only allow numeric expressions in computed question expression
 *  	- check expressions of computed types
 */
public class FormVisitor implements IFormVisitor {
	private final Map<Ident, Type> typeEnv;
	private final List<Message> errors;

	public FormVisitor(Map<Ident, Type> tenv, List<Message> errors) {
		this.typeEnv = tenv;
		this.errors = errors;
	}

	@Override
	public void visit(ComputedQuestion question) {
		checkName(question.getId(), question.getType());
		checkExpr(question.getExpr());

		checkIfCompatibleAndNumeric(question);
	}

	@Override
	public void visit(NormalQuestion question) {
		checkName(question.getId(), question.getType());
	}

	@Override
	public void visit(IfThenElse ifThenElse) {
		checkIfConditionIsOfBooleanType(ifThenElse.getCondition());

		for (Statement stmt : ifThenElse.getIfBlock()) {
			stmt.accept(this);
		}
		for (Statement stmt : ifThenElse.getElseBlock()) {
			stmt.accept(this);
		}
	}
	

	@Override
	public void visit(IfThen ifThen) {
		checkIfConditionIsOfBooleanType(ifThen.getCondition());

		for (Statement stmt : ifThen.getIfBlock()) {
			stmt.accept(this);
		}
	}

	@Override
	public void visit(Form form) {
		for (Statement stmt : form.getStatements()) {
			stmt.accept(this);
		}
	}

	private void checkName(Ident id, Type type) {
		if (typeEnv.containsKey(id)) {
			addError(String.format("Duplicate question identiefier: '%s'",
					id.getValue()));
		} else {
			typeEnv.put(id, type);
		}
	}

	private void checkExpr(Expr expr) {
		expr.accept(new ExpressionVisitor(typeEnv, errors));
	}

	private void checkIfConditionIsOfBooleanType(Expr expr) {
		checkExpr(expr);

		Type exprType = expr.typeOf(typeEnv);
		if (!exprType.isCompatibleToBooleanType()) {
			addError(String.format(
					"Condition is not an boolean expression. %s type given.",
					exprType.toString()));
		}
	}

	private void checkIfCompatibleAndNumeric(ComputedQuestion question) {
		if (!question.getType().isCompatibleTo(
				question.getExpr().typeOf(typeEnv))) {

			addError(String
					.format("Question '%s' returns invalid expression: %s type expected, %s type given.",
							question.getId().getValue(), question.getType(),
							question.getExpr().typeOf(typeEnv)));
			
		} else if (!question.getExpr().typeOf(typeEnv)
				.isCompatibleToNumericType()) {

			addError(String
					.format("Invalid type for computed question '%s'. Only numeric expressions are allowed in computed questions, %s type given.",
							question.getId().getValue(), question.getExpr()
									.typeOf(typeEnv)));
		}
	}

	private void addError(String message) {
		Message error = new Error(message);
		errors.add(error);
	}

	private void addWarning(String message) {
		Message warning = new Warning(message);
		errors.add(warning);
	}

	public List<Message> getMessages() {
		return errors;
	}

}
