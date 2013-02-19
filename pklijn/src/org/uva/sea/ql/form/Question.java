package org.uva.sea.ql.form;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.extensions.Tuple;
import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.form.questiontypes.AbstractQuestionTypeComponent;
import org.uva.sea.ql.messages.Error;

public class Question extends FormItem {

	private final Ident id;
	private final String label;
	private final Type questionType;
	private final JLabel questionLabel;
	private final AbstractQuestionTypeComponent answerComponent;
	
	public Question(Ident id, String question, Type questionType) {
		this.id = id;
		this.label = question;
		this.questionType = questionType;
		questionLabel = new JLabel(label);
		answerComponent = questionType.getAnswerField();
	}
	
	public Ident getId() {
		return id;
	}
	
	protected String getLabel() {
		return label;
	}
	
	protected Type getQuestionType() {
		return questionType;
	}
	
	protected JLabel getQuestionLabel() {
		return questionLabel;
	}
	
	protected AbstractQuestionTypeComponent getAnswerComponent() {
		return answerComponent;
	}

	@Override
	public String getPrintableText(int level) {
		String printableText = getIndent(level);
		printableText += id + ": " + label + " " + questionType + "\n";
		printableText += getErrorText();
		return printableText;
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
	public void buildForm(JPanel mainPanel, Env environment, Form form) {
		mainPanel.add(questionLabel);
		mainPanel.add(answerComponent.getAnswerField(true, environment, form, id), "span");
	}
	
	@Override
	public void setVisible(Boolean visible) {
		questionLabel.setVisible(visible);
		answerComponent.setVisible(visible);
	}

	@Override
	public void eval(Env environment) {}
	
	@Override
	public boolean isFinished(Env environment) {
		return answerComponent.hasValue();
	}
	
	@Override
	public List<Tuple<Ident, Value>> getAllValues(Env environment) {
		ArrayList<Tuple<Ident, Value>> values = new ArrayList<Tuple<Ident, Value>>();
		values.add(new Tuple<Ident, Value>(id, environment.getValue(id)));
		return values;
	}
}
