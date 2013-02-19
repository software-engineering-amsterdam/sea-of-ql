package org.uva.sea.ql.visitor.typeCheck;

import java.util.List;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.stmt.IfThen;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.Statement;
import org.uva.sea.ql.ast.stmt.question.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.question.NormalQuestion;
import org.uva.sea.ql.message.Error;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.IFormVisitor;

/*
 * This FormTypeCheckVisitor checks for:
 * 	- duplicate question ids
 *  - validity of expressions
 *  	- only allow boolean expressions in if condition
 *  	- only allow numeric expressions in computed question expression
 *  	- check expressions of computed types
 */
public class FormTypeCheckVisitor implements IFormVisitor {
	private final TypeMapper typeMapper;
	private final List<Message> errors;
	private final String ERROR_DUPLICATE_ID = "Duplicate question identifier: '%s'";
	private final String ERROR_BOOL_CONDITION = "Condition is not an boolean expression. %s type given.";
	private final String ERROR_WRONG_TYPE = "Question '%s' returns invalid expression: %s type expected, %s type given.";
	private final String ERROR_WRONG_COMPUTED_TYPE = "Invalid type for computed question '%s'. " +
			"Only numeric expressions are allowed in computed questions, %s type given.";
	
	public FormTypeCheckVisitor(TypeMapper typeMapper, List<Message> errors) {
		this.typeMapper = typeMapper;
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
		if (typeMapper.hasTypeKey(id)) {
			addError(String.format(ERROR_DUPLICATE_ID, id.getName()));
		} else {
			typeMapper.setType(id, type);
		}
	}

	private void checkExpr(Expr expr) {
		expr.accept(new ExpressionTypeVisitor(typeMapper, errors));
	}

	private void checkIfConditionIsOfBooleanType(Expr expr) {
		checkExpr(expr);

		Type exprType = expr.typeOf(typeMapper);
		if (!exprType.isCompatibleToBooleanType()) {
			addError(String.format(ERROR_BOOL_CONDITION, exprType.toString()));
		}
	}

	private void checkIfCompatibleAndNumeric(ComputedQuestion question) {
		if (!question.getType().isCompatibleTo(
				question.getExpr().typeOf(typeMapper))) {

			addError(String.format(ERROR_WRONG_TYPE,
							question.getId().getName(), question.getType(),
							question.getExpr().typeOf(typeMapper)));
			
		} else if (!question.getExpr().typeOf(typeMapper)
				.isCompatibleToNumericType()) {

			addError(String
					.format(ERROR_WRONG_COMPUTED_TYPE,
							question.getId().getName(), question.getExpr()
									.typeOf(typeMapper)));
		}
	}

	private void addError(String message) {
		Message error = new Error(message);
		errors.add(error);
	}

	public List<Message> getMessages() {
		return errors;
	}

}
