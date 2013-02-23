package visitor.ui;

import java.util.Observable;
import java.util.Observer;

import ast.expression.Value;
import ast.statement.QuestionComputed;

import visitor.Environment;
import visitor.evaluator.ExpressionEvaluator;
import visitor.ui.wrapper.Wrapper;

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
		Value value = question.getAssignment().getExpression().accept(new ExpressionEvaluator(environment));
		boolean visible = Boolean.parseBoolean(value.getValue().toString());
		this.environment.setVal(question.getIdent(), value);
		this.environment.notifyObservers(this.question.getIdent());
		this.wrap.setValue(value.getValue().toString());
	}
}