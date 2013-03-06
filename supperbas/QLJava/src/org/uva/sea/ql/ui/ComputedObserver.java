package org.uva.sea.ql.ui;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expression.Value;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.evaluator.Environment;
import org.uva.sea.ql.evaluator.ExpressionEvaluator;
import org.uva.sea.ql.ui.wrapper.Wrapper;



public class ComputedObserver implements Observer {
	private final Wrapper wrap;
	private final Environment environment;
	private final QuestionComputed question;

	public ComputedObserver(Wrapper wrap, Environment environment, QuestionComputed question) {
		this.wrap = wrap;
		this.environment = environment;
		this.question = question;
	}

	public void update(Observable observable, Object arg) {
		Value value = question.getExpression().accept(new ExpressionEvaluator(environment));
		this.environment.setVal(question.getIdent(), value);
		this.environment.notifyObservers(this.question.getIdent());
		this.wrap.setValue(value.getValue().toString());
	}
}
