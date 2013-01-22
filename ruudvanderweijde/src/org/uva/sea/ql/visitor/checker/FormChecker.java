package org.uva.sea.ql.visitor.checker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.question.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.question.NormalQuestion;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.FormVisitor;

/*
 * This SemanticVisitor check for:
 * 	- THIS WHOLE FILE NEEDS TE BE REVIEWED
 * 	- THIS WAS ONLY A TEST FILE
 * 
 * 	- duplicate form ids
 * 	- duplicate question ids
 * 	- expressions (TODO)
 * 	- computed questions (TODO)
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
	public void visit(Form form) {
		if (formIds.contains(form.getId().getValue())) {
			addErrorMessage("Duplicate form id: " + form.getId().getValue());
		}
		formIds.add(form.getId().getValue());
	}

	@Override
	public void visit(IfThenElse ifThenElse) {
		//ifThenElse.accept(this);
	}

	@Override
	public void visit(NormalQuestion question) {
		if (typeEnv.containsKey(question.getId())) {
			addErrorMessage("Duplicate question id: " + question.getId().getValue());
		}
		typeEnv.put(question.getId(), question.getType());
	}

	@Override
	public void visit(ComputedQuestion question) {
		if (typeEnv.containsKey(question.getId())) {
			addErrorMessage("Duplicate question id: " + question.getId().getValue());
		}
		//questionTable.put(question.getId().getValue(), question);
	}
	
	@Override
	public void visit(Type type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Expr expr) {
		// TODO Auto-generated method stub
		
	}

	public void addErrorMessage(String message) {
		errors.add(message);
	}
	
	public List<String> getMessages() {
		return errors;
	}

}
