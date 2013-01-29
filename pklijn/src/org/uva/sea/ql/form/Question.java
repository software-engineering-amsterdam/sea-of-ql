package org.uva.sea.ql.form;

import java.awt.Label;
import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.eval.EnvAddIdentResults;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.interpreter.FormElement;
import org.uva.sea.ql.messages.Error;

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
		if (environment.addIdent(id, questionType) == EnvAddIdentResults.DIFFERENT_TYPE_FOUND) {
			errors.add(new Error("Ident " + id + " already defined with other type!"));
		}
		return errors.size() == 0;
	}

	@Override
	public List<FormElement> getFormComponents() {
		List<FormElement> components = new ArrayList<FormElement>();
		
		components.add(new FormElement(new Label(label), "skip"));
		components.add(new FormElement(questionType.getAnswerField(true), "span, growx"));

		return components;
	}
}
