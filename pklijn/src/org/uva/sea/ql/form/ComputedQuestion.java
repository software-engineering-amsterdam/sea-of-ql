package org.uva.sea.ql.form;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.messages.Error;

public class ComputedQuestion extends Question {

	private final Expr expression;
	
	public ComputedQuestion(Ident id, String question, Type questionType, Expr expression) {
		super(id,question,questionType);
		this.expression = expression;
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	@Override
	public String getPrintableText(int level) {
		String printableText = getIndent(level);
		printableText += id + ": " + label + " " + questionType + "(" + expression + ")" + "\n";
		printableText += getErrorText();
		return printableText;
	}
	
	@Override
	public boolean validate(Env environment) {
		errors.addAll(expression.checkType(environment));
		if (expression.typeOf(environment).getClass() != questionType.getClass()) {
			errors.add(new Error("" +
					"ComputedQuestion " + id + 
					" requires the expression to give a " + questionType + 
					" result (" + expression.typeOf(environment) + " given)"));
		}
		boolean valid = super.validate(environment);
		return errors.size() == 0 && valid;
	}
	
	@Override
	public void buildForm(JPanel mainPanel, Env environment, Form form) {
		mainPanel.add(questionLabel);
		mainPanel.add(answerComponent.getAnswerField(false, environment, form, id), "span");
	}
	
	@Override
	public void eval(Env environment) {
		Value expressionValue = expression.eval(environment);
		if (expressionValue != null) {
			answerComponent.setAnswerFieldValue(expressionValue);
			environment.addValue(id, expressionValue);
		}
	}
}
