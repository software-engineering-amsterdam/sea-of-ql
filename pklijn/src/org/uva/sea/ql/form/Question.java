package org.uva.sea.ql.form;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.extensions.Tuple;
import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.messages.Error;

public class Question extends FormItem {

	protected final Ident id;
	protected final String label;
	protected final Type questionType;
	protected JLabel questionLabel;
	protected JComponent answerComponent;
	
	public Question(Ident id, String question, Type questionType) {
		this.id = id;
		this.label = question;
		this.questionType = questionType;
		questionLabel = new JLabel(label);
		answerComponent = questionType.getAnswerField(true);
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
	public void buildForm(JPanel mainPanel) {
		mainPanel.add(questionLabel);
		mainPanel.add(answerComponent, "span");
	}
	
	@Override
	public void setVisible(Boolean visible) {
		questionLabel.setVisible(visible);
		answerComponent.setVisible(visible);
	}

	@Override
	public void eval(Env environment, Form form) {
		questionType.setForm(form);
		if (questionType.hasValue()) {
			environment.addValue(id, questionType.getAnswerFieldValue(answerComponent));
		}
	}
	
	@Override
	public List<Tuple<Ident, Value>> getAllValues() {
		return new ArrayList<Tuple<Ident, Value>>();
	}
}
