package org.uva.sea.ql.form;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;

public class Question extends FormItem {

	private final Ident id;
	private final String label;
	private final Type questionType;
	
	public Question(Ident id, String question, Type questionType) {
		this.id = id;
		this.label = question;
		this.questionType = questionType;
	}
	
	public Ident getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public Type getQuestionType() {
		return questionType;
	}

	@Override
	public void print(int level) {
		printIndent(level);
		System.out.println("Q:" + label 
				+ " (id: " + id.getName() 
				+ ", type: " + questionType + ")");
		printErrors();
	}

	@Override
	public boolean validate(Env environment) {
		environment.addIdent(id, questionType);
		return true;
	}
}
