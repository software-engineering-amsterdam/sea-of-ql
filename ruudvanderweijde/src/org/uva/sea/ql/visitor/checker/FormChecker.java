package org.uva.sea.ql.visitor.checker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.Statement;
import org.uva.sea.ql.ast.stmt.question.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.question.NormalQuestion;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.FormVisitor;

/*
 * This SemanticVisitor checks for:
 * 	- duplicate form ids
 * 	- duplicate question ids
 *  - validity of expressions
 */
public class FormChecker implements FormVisitor {
	private final Map<Ident, Type> typeEnv;
	private final List<String> formIds;
	private final List<String> errors;

	public FormChecker(Map<Ident, Type> tenv, List<String> errors) {
		this.typeEnv = tenv;
		this.errors = errors;
		this.formIds = new ArrayList<String>();
	}

	@Override
	public void visit(ComputedQuestion question) {
		Type computedType = question.getExpr().typeOf(typeEnv);
		checkIdentName(question.getId(), computedType);
		checkExpr(question.getExpr());
		
		// check if computed type is the same as question type
		if (!question.getType().isCompatibleTo(computedType)) {
			addErrorMessage(String.format("%s returns invalid expression: %s type expected, %s type given.", 
					question.getId().getValue(), question.getType(), question.getExpr().typeOf(typeEnv)));
		}
	}

	@Override
	public void visit(NormalQuestion question) {
		checkIdentName(question.getId(), question.getType());
	}

	
	@Override
	public void visit(IfThenElse ifThenElse) {
		
		checkExpr(ifThenElse.getCondition());

		for (Statement stmt : ifThenElse.getIfBlock()) {
			stmt.accept(this);
		}

		for (Statement stmt : ifThenElse.getElseBlock()) {
			stmt.accept(this);
		}
	}
	

	@Override
	public void visit(Form form) {
		
		checkFormName(form.getId());
		
		for (Statement stmt : form.getStatements()) {
			stmt.accept(this);
		}
	}
	
	
	private void checkIdentName(Ident id, Type type) {
		if (typeEnv.containsKey(id)) {
			addErrorMessage("Duplicate question id: " + id.getValue());
		} else {
			typeEnv.put(id, type);
		}
	}
	
	private void checkFormName(Ident id) {
		if (formIds.contains(id.getValue())) {
			addErrorMessage("Duplicate form id: " + id.getValue());
		} else {
			formIds.add(id.getValue());
		}
	}
	
	private void checkExpr(Expr expr) {
		expr.accept(new ExpressionChecker(typeEnv, errors));
    }
	
	private void addErrorMessage(String message) {
		errors.add(message);
	}

	public List<String> getMessages() {
		return errors;
	}

}
