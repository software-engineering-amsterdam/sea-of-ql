package org.uva.sea.ql.form;

import java.awt.Component;
import java.awt.Label;
import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.interpreter.FormElement;
import org.uva.sea.ql.messages.Error;

public class Question extends FormItem {

	private final Ident id;
	private final String label;
	protected final Type questionType;
	protected Component answerComponent;
	
	public Question(Ident id, String question, Type questionType) {
		this.id = id;
		this.label = question;
		this.questionType = questionType;
		this.answerComponent = questionType.getAnswerField(true);
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
		if (environment.hasIdent(id)) {
			if (!(environment.typeOf(id).equals(questionType))) {
				errors.add(new Error("Ident " + id + " already defined with other type!"));
			}
		}
		else {
			environment.addIdent(id, questionType);
		}
		return errors.size() == 0;
	}

	@Override
	public List<FormElement> getFormComponents() {
		return getQuestionComponents();
	}
	
	protected List<FormElement> getQuestionComponents() {
		List<FormElement> components = new ArrayList<FormElement>();
		components.add(new FormElement(new Label(label), "skip"));
		components.add(new FormElement(answerComponent, "span, growx"));
		return components;
	}

	@Override
	public void eval(Env environment, Form form) {
		questionType.setForm(form);
		if (questionType.hasValue()) {
			environment.addValue(id, questionType.getAnswerFieldValue(answerComponent));
		}
	}
}
