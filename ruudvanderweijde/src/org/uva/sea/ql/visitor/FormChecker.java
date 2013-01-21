package org.uva.sea.ql.visitor;

import java.util.HashMap;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.ast.type.Type;

/*
 * This SemanticVisitor check for:
 * 	- duplicate form ids
 * 	- duplicate question ids
 * 	- expressions (TODO)
 * 	- computed questions (TODO)
 */
class FormChecker implements FormVisitor {
	private String errorString;
	private HashMap<String, Form> formTable = new HashMap<String, Form>();
	private HashMap<String, Question> questionTable = new HashMap<String, Question>();

	public FormChecker() {

	}

	@Override
	public void visit(Form form) {
		if (formTable.containsKey(form.getId().getName())) {
			addError("Duplicate form id: " + form.getId().getName());
		}
		formTable.put(form.getId().getName(), form);
	}

	@Override
	public void visit(IfThenElse ifThenElse) {
		//ifThenElse.accept(this);
	}

	@Override
	public void visit(Question question) {
		if (questionTable.containsKey(question.getId().getName())) {
			addError("Duplicate question id: " + question.getId().getName());
		}
		questionTable.put(question.getId().getName(), question);
	}

	@Override
	public void visit(Type type) {
		// TODO Auto-generated method stub

	}

	private void addError(String error) {
		this.setErrorString(this.getErrorString() + (error + "\n"));
		// because the output is not working yet, print the error.
		System.out.println(error);
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

}
