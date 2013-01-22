package org.uva.sea.ql.visitor.checker;

import java.util.HashMap;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.NormalQuestion;
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
	private String errorString;
	private HashMap<String, Form> formTable = new HashMap<String, Form>();
	private HashMap<String, NormalQuestion> questionTable = new HashMap<String, NormalQuestion>();

	public FormChecker() {

	}

	@Override
	public void visit(Form form) {
		if (formTable.containsKey(form.getId().getValue())) {
			addError("Duplicate form id: " + form.getId().getValue());
		}
		formTable.put(form.getId().getValue(), form);
	}

	@Override
	public void visit(IfThenElse ifThenElse) {
		//ifThenElse.accept(this);
	}

	@Override
	public void visit(NormalQuestion question) {
		if (questionTable.containsKey(question.getId().getValue())) {
			addError("Duplicate question id: " + question.getId().getValue());
		}
		questionTable.put(question.getId().getValue(), question);
	}

	@Override
	public void visit(ComputedQuestion question) {
		if (questionTable.containsKey(question.getId().getValue())) {
			addError("Duplicate question id: " + question.getId().getValue());
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
