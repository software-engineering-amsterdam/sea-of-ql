package org.uva.sea.ql.form;

import java.util.List;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.interpreter.FormElement;
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
	public void print(int level) {
		printIndent(level);
		System.out.println("Q:" + getLabel() 
				+ " (id: " + getId().getName()
				+ ", type: " + getQuestionType ()
				+ ", expression: " + expression + ")");
		printErrors();
	}
	
	@Override
	public boolean validate(Env environment) {
		errors.addAll(expression.checkType(environment));
		if (expression.typeOf(environment).getClass() != getQuestionType().getClass()) {
			errors.add(new Error("" +
					"ComputedQuestion " + getId() + 
					" requires the expression to give a " + getQuestionType() + 
					" result (" + expression.typeOf(environment) + " given)"));
		}
		boolean valid = super.validate(environment);
		return errors.size() == 0 && valid;
	}
	
	@Override
	public List<FormElement> getFormComponents() {
		return getQuestionComponents(false);
	}
}
